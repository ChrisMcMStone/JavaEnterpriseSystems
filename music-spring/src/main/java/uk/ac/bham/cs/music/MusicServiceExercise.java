package uk.ac.bham.cs.music;

import uk.ac.bham.cs.music.model.User;

/**
 * An extension of the class test for an exercise.
 * 
 * @author John T. Saxon <j.t.saxon@cs.bham.ac.uk>
 */
public interface MusicServiceExercise extends MusicService {
	/**
	 * Get a user from the database.
	 * 
	 * @param username The username of the user.
	 * @return the user that relates to that user.
	 * @throws IllegalArgumentException when username doesn't exist.
	 * @throws SQLException when database error occurs.
	 */
	public User getUser(String username) throws IllegalArgumentException;
	
	/**
	 * Add a track to a user's database.
	 * 
	 * NOTE: If you're transactions are setup you can use getTrackById() in here and the one above.
	 * 
	 * @param username
	 * @param trackId
	 * @throws IllegalArgumentException when username doesn't exist.
	 * @throws IllegalArgumentException when trackId doesn't exist.
	 */
	public void addToBasket(String username, Integer trackId);
	
	/**
	 * Purchase the user's basket.
	 * 
	 * @param username The username of the user.
	 */
	public void purchase(String username);
}
