package uk.ac.bham.cs.music;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.dao.DataIntegrityViolationException;

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
	 * Get an artist.
	 *
	 * @param name an artist's name
	 * @return an artist
	 */
	public Artist getArtist(String name);

	/**
	 * Create a new artist.
	 *
	 * @param name the artist's name.
	 * @param formationDate the date that the band formed.
	 * @throws DataIntegrityViolationException when artist already exists (should be automatic...).
	 */
	public void newArtist(String name, LocalDate formationDate) throws DataIntegrityViolationException;
	
	/**
	 * Get a track by its ID.
	 * 
	 * @param id the track ID.
	 * @return a track
	 * @throws IllegalArgumentException when id doesn't exist.
	 */
	public Track getTrackById(Integer id);

	/**
	 * Get an artist with their albums attached in release date order.
	 * 
	 * @param name the name of the artist
	 * @return An artist with their albums attached in release date order.
	 */
	public Artist getArtistWithAlbums(String name);
}
