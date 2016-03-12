package uk.ac.bham.cs.music.hibernate.dao.impl;

import org.hibernate.SessionFactory;

import uk.ac.bham.cs.music.dao.AlbumReviewDAO;
import uk.ac.bham.cs.music.model.AlbumReview;

public class AlbumReviewDAOImpl implements AlbumReviewDAO {
	private SessionFactory sessionFactory;
		
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(AlbumReview albumReview) {
		this.getSessionFactory().getCurrentSession().save(albumReview);
	}

}
