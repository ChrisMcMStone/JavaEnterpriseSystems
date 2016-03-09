package uk.ac.bham.cs.music.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import uk.ac.bham.cs.music.dao.ArtistDAO;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.impl.ArtistImpl;

public class ArtistDAOImpl implements ArtistDAO {
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
	public Artist getById(Integer id) {
		return this.getSessionFactory()
				.getCurrentSession()
				.get(ArtistImpl.class, id);
	}

	@Override
	public Artist getByName(String name) {
		return (Artist) this.getSessionFactory()
				.getCurrentSession()
				.createCriteria(ArtistImpl.class)
				.add(Restrictions.eq("name", name))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artist> getArtists() {
		return this.getSessionFactory()
				.getCurrentSession()
				.createCriteria(ArtistImpl.class)
				.addOrder(Order.asc("name"))
				.list();
	}

	@Override
	public void save(Artist artist) {
		this.getSessionFactory().getCurrentSession().save(artist);
	}
}
