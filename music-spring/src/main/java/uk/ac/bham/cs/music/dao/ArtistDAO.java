package uk.ac.bham.cs.music.dao;

import java.util.List;

import uk.ac.bham.cs.music.model.Artist;

public interface ArtistDAO {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Artist getById(Integer id);
	
	/**
	 * 
	 * @return
	 */
	public Artist getByName(String name);
	
	/**
	 * 
	 * @return
	 */
	public List<Artist> getArtists();
	
	/**
	 * 
	 * @param artist
	 */
	public void save(Artist artist);
}
