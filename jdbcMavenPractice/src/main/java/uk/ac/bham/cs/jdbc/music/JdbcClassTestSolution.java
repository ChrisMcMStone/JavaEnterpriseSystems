package uk.ac.bham.cs.jdbc.music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.Duration;
import org.joda.time.LocalDate;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.impl.AlbumImpl;
import uk.ac.bham.cs.music.model.impl.ArtistImpl;
import uk.ac.bham.cs.music.model.impl.TrackImpl;

/**
 * Example class test answers for Enterprise Systems.
 * 
 * @author John T. Saxon <j.t.saxon@cs.bham.ac.uk>
 */
public class JdbcClassTestSolution implements JdbcMusicService {
	/**
	 * Database connector.
	 */
	private Connection db;
	
	public JdbcClassTestSolution(Connection db) {
		this.db = db;
	}

	@Override
	public Connection getConnection() {
		return this.db;
	}

	@Override
	public List<Artist> getArtists() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Artist> artists = new ArrayList<Artist>();
		try {
			// create a prepared statement
			stmt = this.getConnection()
						.prepareStatement("SELECT id, name, formation_date, disbandment_date FROM artist ORDER BY name ASC");
			// execute it
			rs = stmt.executeQuery();
			// do we have one?
			while(rs.next()) {
				// create a track
				Artist artist = new ArtistImpl();
				artist.setId(rs.getInt(1));
				artist.setName(rs.getString(2));
				artist.setFormationDate(new LocalDate(rs.getDate(3)));
				Date disbandmentDate = rs.getDate(4);
				if(!rs.wasNull()) { // was the last get*() an SQL NULL?
					artist.setDisbandmentDate(new LocalDate(disbandmentDate));
				}
				artists.add(artist);
			}
			
			return artists; // return it
		} catch(SQLException e) {
			// we have an issue, time to go.
			throw new RuntimeException(e);
		} finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				// we have an issue, time to go.
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public List<Album> getAlbums(Artist artist) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Album> albums = new ArrayList<Album>();
		try {
			// create a prepared statement
			stmt = this.getConnection()
						.prepareStatement("SELECT id, name, release_date, price FROM album WHERE artist_id = ? ORDER BY release_date DESC");
			// set the parameter
			stmt.setInt(1, artist.getId());
			// execute it
			rs = stmt.executeQuery();
			// do we have one?
			while(rs.next()) {
				// create a track
				Album album = new AlbumImpl();
				album.setId(rs.getInt(1));
				album.setName(rs.getString(2));
				album.setReleaseDate(new LocalDate(rs.getDate(3)));
				album.setPrice(rs.getDouble(4));
				albums.add(album);
				
				// optional
				album.setArtist(artist);
			}
			
			// optional
			artist.setAlbums(albums);
			
			return albums; // return it
		} catch(SQLException e) {
			// we have an issue, time to go.
			throw new RuntimeException(e);
		} finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				// we have an issue, time to go.
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public Artist getArtist(String name) throws IllegalArgumentException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Artist artist = null;
		try {
			// create a prepared statement
			stmt = this.getConnection()
						.prepareStatement("SELECT id, name, formation_date, disbandment_date FROM artist WHERE name = ?");
			// set the parameter
			stmt.setString(1, name);
			// execute it
			rs = stmt.executeQuery();
			// do we have one?
			if(rs.next()) {
				// create a track
				artist = new ArtistImpl();
				artist.setId(rs.getInt(1));
				artist.setName(rs.getString(2));
				artist.setFormationDate(new LocalDate(rs.getDate(3)));
				Date disbandmentDate = rs.getDate(4);
				if(!rs.wasNull()) { // was the last get*() an SQL NULL?
					artist.setDisbandmentDate(new LocalDate(disbandmentDate));
				}
			} else {
				throw new IllegalArgumentException("No such artist.");
			}
			
			return artist; // return it
		} catch(SQLException e) {
			// we have an issue, time to go.
			throw new RuntimeException(e);
		} finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				// we have an issue, time to go.
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void newArtist(String name, LocalDate formationDate) throws IllegalArgumentException {
		PreparedStatement stmt = null;
		
		try {
			// something different for you all to think about...
			// see the interface for what getArtist() does.
			try {
				// does this artist already exist?
				this.getArtist(name);
			} catch(IllegalArgumentException e) {
				// create a prepared statement
				stmt = this.getConnection()
							.prepareStatement("INSERT INTO artist (name, formation_date) values(?, ?)");
				// set the parameter
				stmt.setString(1, name);
				stmt.setDate(2, new Date(formationDate.toDate().getTime()));
				// execute it
				stmt.executeUpdate();
				
				// break out.
				return;
			}

			throw new IllegalArgumentException("Artist already exists.");
		} catch(SQLException e) {
			// we have an issue, time to go.
			throw new RuntimeException(e);
		} finally {
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				// we have an issue, time to go.
				throw new RuntimeException(e);
			}
		}
	}
	
	@Override
	public Track getTrackById(Integer id) throws IllegalArgumentException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Track track = null;
		try {
			// create a prepared statement
			stmt = this.getConnection()
						.prepareStatement("SELECT id, title, length FROM track WHERE id = ?");
			// set the parameter
			stmt.setInt(1, id);
			// execute it
			rs = stmt.executeQuery();
			// do we have one?
			if(rs.next()) {
				// create a track
				track = new TrackImpl();
				track.setId(rs.getInt(1));
				track.setTitle(rs.getString(2));
				track.setLength(new Duration(rs.getLong(3)));
				
				return track;
			}
			
			throw new IllegalArgumentException("Track doesn't exist.");
		} catch(SQLException e) {
			// we have an issue, time to go.
			throw new RuntimeException(e);
		} finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				// we have an issue, time to go.
				throw new RuntimeException(e);
			}
		}
	}
}
