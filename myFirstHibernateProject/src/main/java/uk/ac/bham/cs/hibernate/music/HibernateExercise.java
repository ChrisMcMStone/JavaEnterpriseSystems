package uk.ac.bham.cs.hibernate.music;

import java.util.List;

import org.hibernate.SessionFactory;

import uk.ac.bham.cs.music.MusicServiceExercise;
import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;

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
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Purchase> getPurchases(User user) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addToBasket(User user, Track track) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void purchase(User user) {
		throw new UnsupportedOperationException();
	}
}
