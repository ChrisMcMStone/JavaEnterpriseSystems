package uk.ac.bham.cs.hibernate.music;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.joda.time.LocalDate;

import uk.ac.bham.cs.music.MusicServiceExercise;
import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;
import uk.ac.bham.cs.music.model.impl.AlbumImpl;
import uk.ac.bham.cs.music.model.impl.PurchaseImpl;

public class HibernateExercise extends HibernateClassTest implements MusicServiceExercise {
	/**
	 * 
	 * @param sessionFactory
	 */
	public HibernateExercise(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public User getUser(String username) throws IllegalArgumentException {
		User user = null;
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Query query = session.createQuery("from UserImpl where username = :username"); 
			query.setParameter("username", username);
			user = (User) query.uniqueResult();
			if(user == null) {
				throw new IllegalArgumentException("User \""+username+"\" does not exist");
			}
			tx.commit();
			return user;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getPurchases(User user) {
		List<Purchase> purchases = null;
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Query query = session.createQuery("from PurchaseImpl where user = :user");
			query.setParameter("user", user);
			purchases = query.list();
			if(purchases == null) {
				throw new IllegalArgumentException("User has made no purchases");
			}
			tx.commit();
			return purchases;
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		}
		return purchases;
	}

	@Override
	public void addToBasket(User user, Track track) throws IllegalArgumentException {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			user.getBasket().add(track);
			session.saveOrUpdate(user);
			tx.commit();
		
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			if(e instanceof ConstraintViolationException) {
				throw new IllegalArgumentException("Track already in users basket");
			} else {
				e.printStackTrace();
			}
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	@Override
	public void purchase(User user) throws IllegalArgumentException {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Purchase purchase = new PurchaseImpl();
			purchase.setUser(user);
			purchase.setTracks(user.getBasket());
			purchase.setPurchaseDate(new LocalDate());
			Set<Track> tracks = user.getBasket();
			double price = 0;
			for(Track track : tracks) {
				price += track.getPrice().doubleValue();
			}
			purchase.setPrice(price);
			session.save(purchase);
			
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			if(e instanceof ConstraintViolationException) {
				throw new IllegalArgumentException("No tracks in basket");
			} else {
				e.printStackTrace();
			}
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	@Override
	public void newAlbum(String name, String artistName, LocalDate releaseDate, Double price) throws IllegalArgumentException {
		Artist artist = getArtist(artistName);
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Album album = new AlbumImpl();
			album.setName(name);
			album.setArtist(artist);
			album.setReleaseDate(releaseDate);
			album.setPrice(price);
			session.save(album);
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			if(e instanceof ConstraintViolationException) {
				throw new IllegalArgumentException("Album already exists.");
			} else {
				e.printStackTrace();
			}
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	@Override
	public void deleteAlbum(String artistName, String albumName) {
		Artist artist = getArtist(artistName);
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Query query = session.createQuery("delete AlbumImpl where name=:name and artist=:artist");
			query.setParameter("name", albumName);
			query.setParameter("artist", artist);
			if(query.executeUpdate() == 0) 
				throw new IllegalArgumentException("Given artist does not have given album.");
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
	}
}
