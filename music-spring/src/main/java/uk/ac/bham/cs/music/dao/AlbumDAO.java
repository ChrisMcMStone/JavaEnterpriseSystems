package uk.ac.bham.cs.music.dao;

import java.util.Set;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;

public interface AlbumDAO {
	/**
	 * 
	 * @return
	 */
	public Album getByName(String name);
	
	/**
	 * 
	 * @param artist
	 * @return
	 */
	public Set<Album> getByArtist(Artist artist);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Album getById(Integer id);
	
	/**
	 * 
	 * @param album
	 */
	public void save(Album album);
	
	public Album getAlbumWithReviews(Integer id);
}
