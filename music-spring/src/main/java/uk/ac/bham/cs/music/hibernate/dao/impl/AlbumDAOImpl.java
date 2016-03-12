package uk.ac.bham.cs.music.hibernate.dao.impl;

import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import uk.ac.bham.cs.music.dao.AlbumDAO;
import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.impl.AlbumImpl;

public class AlbumDAOImpl implements AlbumDAO {
	
	private SessionFactory sessionFactory;
		
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Album getByName(String name) {
		return (Album) this.getSessionFactory()
				.getCurrentSession()
				.createCriteria(AlbumImpl.class)
				.add(Restrictions.eqOrIsNull("name", name))
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<Album> getByArtist(Artist artist) {
		return (Set<Album>) this.getSessionFactory()
				.getCurrentSession()
				.createCriteria(AlbumImpl.class)
				.add(Restrictions.eq("artist", artist))
				.list();
	}

	@Override
	public Album getById(Integer id) {
		return this.getSessionFactory()
				.getCurrentSession()
				.get(AlbumImpl.class, id);
	}

	@Override
	public void save(Album album) {
		this.getSessionFactory().getCurrentSession().save(album);
	}
	
	public Album getAlbumWithReviews(Integer id) {
		return (Album) this.getSessionFactory()
				.getCurrentSession()
				.createCriteria(AlbumImpl.class)
				.add(Restrictions.eq("id", id))
				.setFetchMode("review", FetchMode.EAGER);
	}

}
