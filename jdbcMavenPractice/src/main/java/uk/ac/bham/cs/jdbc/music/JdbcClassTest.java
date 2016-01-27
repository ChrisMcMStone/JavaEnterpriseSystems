package uk.ac.bham.cs.jdbc.music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.joda.time.Duration;
import org.joda.time.LocalDate;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.impl.TrackImpl;

/**
 * Class test questions for Enterprise Systems.
 * 
 * @author John T. Saxon <j.t.saxon@cs.bham.ac.uk>
 */
public class JdbcClassTest implements JdbcMusicService {
	/**
	 * Database connector.
	 */
	private Connection db;
	
	public JdbcClassTest(Connection db) {
		this.db = db;
	}

	@Override
	public Connection getConnection() {
		return this.db;
	}

	@Override
	public List<Artist> getArtists() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Album> getAlbums(Artist artist) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Artist getArtist(String name) throws IllegalArgumentException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void newArtist(String name, LocalDate formationDate) throws IllegalArgumentException {
		throw new UnsupportedOperationException();
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
