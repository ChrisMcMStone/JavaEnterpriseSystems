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
import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;
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
}
