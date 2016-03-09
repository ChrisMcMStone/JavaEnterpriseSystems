package uk.ac.bham.cs.music.hibernate;

import java.util.List;

import org.joda.time.LocalDate;

import uk.ac.bham.cs.music.dao.AlbumDAO;
import uk.ac.bham.cs.music.dao.ArtistDAO;
import uk.ac.bham.cs.music.dao.PurchaseDAO;
import uk.ac.bham.cs.music.dao.TrackDAO;
import uk.ac.bham.cs.music.dao.UserDAO;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.impl.ArtistImpl;

public class HibernateClassTest implements HibernateMusicService {
	/**
	 * 
	 */
	private TrackDAO trackDAO;
	
	/**
	 * 
	 */
	private ArtistDAO artistDAO;
	
	@Override
	public List<Artist> getArtists() {
		throw new UnsupportedOperationException("You should try this one!");
	}

	@Override
	public Artist getArtist(String name) {
		throw new UnsupportedOperationException("You should try this one!");
	}

	@Override
	public void newArtist(String name, LocalDate formationDate)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("You should try this one!");
	}

	@Override
	public Artist getArtistWithAlbums(String name) {
		throw new UnsupportedOperationException("You should try this one!");
	}

	@Override
	public Track getTrackById(Integer id) {
		return this.getTrackDAO().getById(id);
	}
	
	@Override
	public TrackDAO getTrackDAO() {
		return trackDAO;
	}

	@Override
	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}
	
	@Override
	public ArtistDAO getArtistDAO() {
		return this.artistDAO;
	}

	@Override
	public void setArtistDAO(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}

	@Override
	public AlbumDAO getAlbumDAO() {
		throw new UnsupportedOperationException("You should try this one!");
	}

	@Override
	public void setAlbumDAO(AlbumDAO albumDAO) {
		throw new UnsupportedOperationException("You should try this one!");
	}
	
	@Override
	public UserDAO getUserDAO() {
		throw new UnsupportedOperationException("You should try this one!");
	}

	@Override
	public void setUserDAO(UserDAO userDAO) {
		throw new UnsupportedOperationException("You should try this one!");
	}

	@Override
	public PurchaseDAO getPurchaseDAO() {
		throw new UnsupportedOperationException("You should try this one!");
	}

	@Override
	public void setPurchaseDAO(PurchaseDAO purchaseDAO) {
		throw new UnsupportedOperationException("You should try this one!");
	}
	
	@Override
	public void populate() {
		
	}
}
