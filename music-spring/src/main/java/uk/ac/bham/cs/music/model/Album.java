package uk.ac.bham.cs.music.model;

import java.util.Set;

import org.joda.time.LocalDate;

public interface Album {
	/**
	 * Get the album's ID.
	 *
	 * @return the album's ID
	 */
	public Integer getId();

	/**
	 * Set the album's ID.
	 *
	 * @param id the ID of the album.
	 */
	public void setId(Integer id);

	/**
	 * Get the album's name.
	 *
	 * @return the album's name.
	 */
	public String getName();

	/**
	 * Set the album's name.
	 *
	 * @param name the name of the album.
	 */
	public void setName(String name);

	/**
	 * Get the album's release date.
	 *
	 * @return the album's release date.
	 */
	public LocalDate getReleaseDate();

	/**
	 * Set the album's release date.
	 *
	 * @param releaseDate the release date of the album.
	 */
	public void setReleaseDate(LocalDate releaseDate);

	/**
	 * Get the artist for an album.
	 *
	 * <strong>NO JDBC here! Use the setter!</strong>
	 *
	 * @return the artist for this album.
	 */
	public Artist getArtist();

	/**
	 * Set the artist for an album.
	 *
	 * <strong>NO JDBC here! Don't worry about persistence.</strong>
	 *
	 * @param artist the artist for the album.
	 */
	public void setArtist(Artist artist);

	/**
	 * Get the album's price.
	 *
	 * @return the album's price.
	 */
	public Double getPrice();

	/**
	 * Set the album's price.
	 *
	 * @param price the price of the album.
	 */
	public void setPrice(Double price);

	/**
	 * Get the tracks for an album.
	 *
	 * <strong>NO JDBC here! Use the setter!</strong>
	 *
	 * @return the list of tracks for this album.
	 */
	public Set<Track> getTracks();

	/**
	 * Set the tracks for an album.
	 *
	 * <strong>NO JDBC here! Don't worry about persistence.</strong>
	 *
	 * @param tracks a list of tracks.
	 */
	public void setTracks(Set<Track> tracks);
}
