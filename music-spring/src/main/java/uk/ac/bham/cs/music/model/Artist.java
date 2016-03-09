package uk.ac.bham.cs.music.model;

import java.util.Set;

import org.joda.time.LocalDate;

public interface Artist {
	/**
	 * Get the artist's ID.
	 *
	 * @return the artist's ID
	 */
	public Integer getId();

	/**
	 * Set the artist's ID.
	 *
	 * @param id the ID of the artist.
	 */
	public void setId(Integer id);

	/**
	 * Get the artist's name.
	 *
	 * @return the artist's name.
	 */
	public String getName();

	/**
	 * Set the artist's name.
	 *
	 * @param name the name of the artist.
	 */
	public void setName(String name);

	/**
	 * Get the artist's formation date.
	 *
	 * @return the artist's formation date.
	 */
	public LocalDate getFormationDate();

	/**
	 * Set the artist's formation date.
	 *
	 * @param formationDate the formation date of the artist.
	 */
	public void setFormationDate(LocalDate formationDate);

	/**
	 * Get the artist's disbandment date.
	 *
	 * @return the artist's disbandment date.
	 */
	public LocalDate getDisbandmentDate();

	/**
	 * Set the artist's disbandment date.
	 *
	 * @param disbandmentDate the disbandment date of the artist.
	 */
	public void setDisbandmentDate(LocalDate disbandmentDate);
	
	/**
	 * Get the albums for an artist.
	 *
	 * <strong>NO JDBC here! Use the setter!</strong>
	 *
	 * @return the list of albums for this artist.
	 */
	public Set<Album> getAlbums();

	/**
	 * Set the albums for an artist.
	 *
	 * <strong>NO JDBC here! Don't worry about persistence.</strong>
	 *
	 * @param albums a list of albums.
	 */
	public void setAlbums(Set<Album> albums);
}
