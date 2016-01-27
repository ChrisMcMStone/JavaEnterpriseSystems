package uk.ac.bham.cs.music;

import java.sql.SQLException;
import java.util.List;

import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
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
	 * Get the purchases for a given user.
	 * 
	 * @param user the user that we want purchases from.
	 * @return the list of purchases that the user has made.
	 */
	public List<Purchase> getPurchases(User user);
	
	/**
	 * Add a track to a user's basket.
	 * 
	 * @param user the user that is considering buying.
	 * @param track the track that the user is considering buying.
	 */
	public void addToBasket(User user, Track track);
	
	/**
	 * Purchase the user's basket.
	 * 
	 * <em>Hint</em>:
	 * <ol>
	 * 	<li>You'll need to copy the basket elsewhere.</li>
	 * 	<li>You'll need to empty the basket afterwards.</li>
	 *  <li><code>setAutoCommit</code> might be useful here.</li>
	 * </ol>
	 * 
	 * @param user purchase the user's input.
	 */
	public void purchase(User user);
}
