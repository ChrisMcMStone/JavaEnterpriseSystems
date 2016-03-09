package uk.ac.bham.cs.music.hibernate;

import uk.ac.bham.cs.music.MusicServiceExercise;
import uk.ac.bham.cs.music.model.User;

public class HibernateExercise extends HibernateClassTest implements MusicServiceExercise {
	@Override
	public User getUser(String username) throws IllegalArgumentException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addToBasket(String username, Integer trackId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void purchase(String username) {
		throw new UnsupportedOperationException();
	}
}
