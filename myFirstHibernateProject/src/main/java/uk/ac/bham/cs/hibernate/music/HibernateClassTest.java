package uk.ac.bham.cs.hibernate.music;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.LocalDate;

import uk.ac.bham.cs.hibernate.HibernateService;
import uk.ac.bham.cs.music.MusicService;
import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.impl.ArtistImpl;

public class HibernateClassTest implements HibernateService, MusicService {
	/**
	 * 
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param sessionFactory
	 */
	public HibernateClassTest(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked") //Needed to cast query.list()
	public List<Artist> getArtists() {
		List<Artist> artists = null;
		
		//create session
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			//Create hibernate query
			Query query = session.createQuery("from ArtistImpl");
			artists = (List<Artist>)query.list();
			if(artists == null) {
				throw new IllegalArgumentException("No artists in database");
			}
			tx.commit();
			return artists;
		} catch (HibernateException e) {
			// If something goes wrong then rollback
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		}
		return artists;
	}

	@SuppressWarnings("unchecked") //Needed to cast query.list()
	@Override
	public List<Album> getAlbums(Artist artist) {
		List<Album> albums = null;
		
		//create session
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			//Create hibernate query
			Query query = session.createQuery("from AlbumImpl where artist = :artist");
			query.setParameter("artist", artist);
			albums = (List<Album>)query.list();
			if(albums == null) {
				throw new IllegalArgumentException("No albums by that artist are in database");
			}
			tx.commit();
			return albums;
		} catch (HibernateException e) {
			// If something goes wrong then rollback
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		}
		return albums;
	}

	@Override
	public Artist getArtist(String name) throws IllegalArgumentException {
		Artist artist = null;
		
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Query query = session.createQuery("from ArtistImpl A where A.name = :artist_name");
			query.setParameter("artist_name", name);
			artist = (Artist)query.uniqueResult();
			
			if(artist == null) {
				throw new IllegalArgumentException("No artist with that name exists.");
			}
			tx.commit();
			
			return artist;
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		}
		return artist;
	
	}

	@Override
	public void newArtist(String name, LocalDate formationDate) throws IllegalArgumentException {
		
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Artist artist = new ArtistImpl();
			artist.setName(name);
			artist.setFormationDate(formationDate);
			session.save(artist);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		}
	}

	@Override
	public Track getTrackById(Integer id) throws IllegalArgumentException {
		Track track = null;
		
		// create a session
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// create a query
			Query query = session.createQuery("from TrackImpl where id = :id");
			query.setInteger("id", id);
			
			// attempt to get a unique result.
			track = (Track) query.uniqueResult();
			if(track == null) {
				// no result? error.
				throw new IllegalArgumentException("track " + id + " doesn't exist.");
			}
			
			// commit
			tx.commit();
			
			// return the track
			return track;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		}
		
		return track;
	}
}
