package uk.ac.bham.cs.hibernate;

import uk.ac.bham.cs.music.dao.AlbumDAO;
import uk.ac.bham.cs.music.dao.AlbumReviewDAO;
import uk.ac.bham.cs.music.dao.PurchaseDAO;
import uk.ac.bham.cs.music.dao.TrackDAO;
import uk.ac.bham.cs.music.dao.ArtistDAO;
import uk.ac.bham.cs.music.dao.UserDAO;

public interface HibernateService {
	/**
	 * 
	 */
	public void populate();
	
	/**
	 * 
	 * @return
	 */
	public TrackDAO getTrackDAO();
	
	/**
	 * 
	 * @param trackDAO
	 */
	public void setTrackDAO(TrackDAO trackDAO);
	
	/**
	 * 
	 * @return
	 */
	public ArtistDAO getArtistDAO();
	
	/**
	 * 
	 * @param artistDAO
	 */
	public void setArtistDAO(ArtistDAO artistDAO);
	
	/**
	 * 
	 * @return
	 */
	public AlbumDAO getAlbumDAO();
	
	/**
	 * 
	 * @param albumDAO
	 */
	public void setAlbumDAO(AlbumDAO albumDAO);
	
	/**
	 * 
	 * @return
	 */
	public UserDAO getUserDAO();
	
	/**
	 * 
	 * @param userDAO
	 */
	public void setUserDAO(UserDAO userDAO);
	
	/**
	 * 
	 * @return
	 */
	public PurchaseDAO getPurchaseDAO();
	
	/**
	 * 
	 * @param purchaseDAO
	 */
	public void setPurchaseDAO(PurchaseDAO purchaseDAO);
	
	public void setAlbumReviewDAO(AlbumReviewDAO albumReviewDAO);
	
	public AlbumReviewDAO getAlbumReviewDAO();
}
