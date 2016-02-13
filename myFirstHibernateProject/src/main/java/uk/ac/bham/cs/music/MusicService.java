package uk.ac.bham.cs.music;

import java.util.List;

import org.joda.time.LocalDate;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Track;

/**
 * A minimal music service interface.
 * 
 * Used for the Class Test.
 * 
 * @author John T. Saxon <j.t.saxon@cs.bham.ac.uk>
 */
public interface MusicService {
	/**
	 *  Get all artists in name order.
	 *
	 *  @return a list of artists
	 */
	public List<Artist> getArtists();


	/**
	 * Get a list of albums for a given artist in
	 * release date order.
	 *
	 * @param artist the artist to retrieve
	 * @return a list if albums
	 */
	public List<Album> getAlbums(Artist artist); 

	/**
	 * Get an artist.
	 *
	 * @param name an artist's name
	 * @return an artist
	 * @throws IllegalArgumentException when artist doesn't exist.
	 * @throws SQLException on SQL error.
	 */
	public Artist getArtist(String name) throws IllegalArgumentException;

	/**
	 * Create a new artist.
	 *
	 * @param name the artist's name.
	 * @param formationDate the date that the band formed.
	 * @throws IllegalArgumentException when artist already exists.
	 */
	public void newArtist(String name, LocalDate formationDate) throws IllegalArgumentException;
	
	public void newBandMember(String name, LocalDate formationDate, String bandName) throws IllegalArgumentException;
	
	
	/**
	 * @param id the track ID.
	 * @return a track
	 * @throws IllegalArgumentException when track doesn't exist.
	 * @throws SQLException on SQL error.
	 */
	public Track getTrackById(Integer id) throws IllegalArgumentException;


	public void newBand(String name, LocalDate formationDate) throws IllegalArgumentException;
}
