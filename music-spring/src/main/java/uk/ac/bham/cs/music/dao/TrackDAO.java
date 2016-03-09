package uk.ac.bham.cs.music.dao;

import java.util.List;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Track;

public interface TrackDAO {
	/**
	 * 
	 * @return
	 */
	public Track getById(Integer id);
	
	/**
	 * 
	 * @param albumName
	 * @return
	 */
	public List<Track> getByAlbum(Album albumName);
	
	/**
	 * 
	 * @param track
	 */
	public void save(Track track);
}
