package uk.ac.bham.cs.music.hibernate;

import java.util.List;

import org.joda.time.LocalDate;

import uk.ac.bham.cs.music.dao.AlbumDAO;
import uk.ac.bham.cs.music.dao.AlbumReviewDAO;
import uk.ac.bham.cs.music.dao.ArtistDAO;
import uk.ac.bham.cs.music.dao.PurchaseDAO;
import uk.ac.bham.cs.music.dao.TrackDAO;
import uk.ac.bham.cs.music.dao.UserDAO;
import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;
import uk.ac.bham.cs.music.model.impl.AlbumReviewImpl;
import uk.ac.bham.cs.music.model.impl.ArtistImpl;

public class HibernateClassTest implements HibernateMusicService {
	
	private TrackDAO trackDAO;
	private ArtistDAO artistDAO;
	private AlbumDAO albumDAO;
	private UserDAO userDAO;
	private PurchaseDAO purchaseDAO;
	private AlbumReviewDAO albumReviewDAO;
	
	@Override
	public AlbumReviewDAO getAlbumReviewDAO() {
		return albumReviewDAO;
	}

	@Override
	public void setAlbumReviewDAO(AlbumReviewDAO albumReviewDAO) {
		this.albumReviewDAO = albumReviewDAO;
	}

	@Override
	public List<Artist> getArtists() {
		return artistDAO.getArtists();
	}

	@Override
	public Artist getArtist(String name) {
		return artistDAO.getByName(name);
	}

	@Override
	public void newArtist(String name, LocalDate formationDate)
			throws IllegalArgumentException {
		Artist artist = new ArtistImpl();
		artist.setName(name);
		artist.setFormationDate(formationDate);
		artistDAO.save(artist);
	}

	@Override
	public Artist getArtistWithAlbums(String name) {
		return artistDAO.getByName(name);
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
		return albumDAO;
	}

	@Override
	public void setAlbumDAO(AlbumDAO albumDAO) {
		this.albumDAO = albumDAO;
	}
	
	@Override
	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Override
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public PurchaseDAO getPurchaseDAO() {
		return purchaseDAO;
	}

	@Override
	public void setPurchaseDAO(PurchaseDAO purchaseDAO) {
		this.purchaseDAO = purchaseDAO;
	}
	
	@Override
	public void populate() {
		
	}

	@Override
	public void addReview(String username, String artistName, String albumName, String review) {
		//Assumes unique album names
		Album album = albumDAO.getByName(albumName);
		User user = userDAO.getByUsername(username);
		if(album == null || user == null)
			throw new IllegalArgumentException("Album or user doesn't exist in database");
		AlbumReviewImpl albumReview = new AlbumReviewImpl();
		albumReview.setAlbum(album);
		albumReview.setUser(user);
		albumReview.setReview(review);
		albumReviewDAO.save(albumReview);
	}
}
