package uk.ac.bham.cs.music.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import uk.ac.bham.cs.music.dao.TrackDAO;
import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.impl.TrackImpl;

public class TrackDAOImpl implements TrackDAO {
	/**
	 * 
	 */
	private SessionFactory sessionFactory;
		
	/**
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Track getById(Integer id) {
		return this.getSessionFactory()
				.getCurrentSession()
				.get(TrackImpl.class, id);
	}

	@Override
	public void save(Track track) {
		this.getSessionFactory().getCurrentSession().save(track);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Track> getByAlbum(Album album) {
		return this.getSessionFactory()
				.getCurrentSession()
				.createCriteria(TrackImpl.class, "t")
				.add(Restrictions.eq("album", album))
				.list();
	}
}
