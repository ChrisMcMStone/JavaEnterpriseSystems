package uk.ac.bham.cs.music.model;

import java.util.Set;

import org.joda.time.Duration;

public interface Track {
	/**
	 * Get the track's ID.
	 *
	 * @return the track's ID
	 */
	public Integer getId();

	/**
	 * Set the track's ID.
	 *
	 * @param id the ID of the track.
	 */
	public void setId(Integer id);

	/**
	 * Get the track's title.
	 *
	 * @return the track's title.
	 */
	public String getTitle();

	/**
	 * Set the track's title.
	 *
	 * @param title the title of the track.
	 */
	public void setTitle(String title);

	/**
	 * Get the track's length (in seconds).
	 *
	 * @return the track's length (in seconds).
	 */
	public Duration getLength();

	/**
	 * Set the track's length (as a Time object).
	 *
	 * @param length the length of the track.
	 */
	public void setLength(Duration length);

	/**
	 * Get the albums for an track.
	 *
	 * <strong>NO JDBC here!</strong>
	 *
	 * @return the albums for this track.
	 */
	public Set<Album> getAlbums();
	
	/**
	 * Set the albums for an track.
	 *
	 * <strong>NO JDBC here!</strong>
	 *
	 * @return the albums for this track.
	 */
	public void setAlbums(Set<Album> album);
	
	/**
	 * Get the list of purchase orders that include this track.
	 * 
	 * @return the list of purchase orders that include this track.
	 */
	public Set<Purchase> getPurchases();
	
	/**
	 * Set the list of purchase orders that include this track.
	 * 
	 * @param purchasedBy the list of purchase orders that include this track.
	 */
	public void setPurchases(Set<Purchase> purchasedBy);
	
	public Double getPrice();
	
	public void setPrice(Double price);
	
}
