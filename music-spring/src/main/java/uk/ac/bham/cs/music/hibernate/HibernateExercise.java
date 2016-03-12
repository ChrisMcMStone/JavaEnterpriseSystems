package uk.ac.bham.cs.music.hibernate;

import java.util.Set;

import org.joda.time.LocalDateTime;

import uk.ac.bham.cs.music.MusicServiceExercise;
import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;
import uk.ac.bham.cs.music.model.impl.PurchaseImpl;

public class HibernateExercise extends HibernateClassTest implements MusicServiceExercise {
	@Override
	public User getUser(String username) throws IllegalArgumentException {
		User user = getUserDAO().getByUsername(username);
		if (user == null) 
			throw new IllegalArgumentException("No user with that username in database");
		else
			return user;
	}

	@Override
	public void addToBasket(String username, Integer trackId) {
		User user = getUser(username);
		Track track = getTrackById(trackId);
		if(track == null)
			throw new IllegalArgumentException("No track with with ID: " + trackId + " in database");
		if(!user.getBasket().add(track))
			throw new IllegalArgumentException("Track already in basket");
	}

	@Override
	public void purchase(String username) {
		User user = getUser(username);
		Purchase purchase = new PurchaseImpl();
		purchase.setPurchaseDate(LocalDateTime.now());
		Set<Track> tracks = user.getBasket();
		user.setBasket(null);
		getUserDAO().save(user);
		purchase.setUser(user);
		purchase.setTracks(tracks);
		getPurchaseDAO().save(purchase);
	}
}
