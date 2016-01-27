package uk.ac.bham.cs.music.model;

import java.util.List;

import org.joda.time.DateTime;

public interface User {
	/**
	 * Get the user's ID.
	 *
	 * @return the user's ID
	 */
	public Integer getId();

	/**
	 * Set the user's ID.
	 *
	 * @param id the ID of the user.
	 */
	public void setId(Integer id);

	/**
	 * Get the user's name.
	 *
	 * @return the user's name.
	 */
	public String getName();

	/**
	 * Set the user's name.
	 *
	 * @param name the name of the user.
	 */
	public void setName(String name);
	
	/**
	 * Get the user's username.
	 *
	 * @return the user's username.
	 */
	public String getUsername();

	/**
	 * Set the user's username.
	 *
	 * @param username the username of the user.
	 */
	public void setUsername(String username);
	
	/**
	 * Get the user's password.
	 *
	 * @return the user's password.
	 */
	public String getPassword();

	/**
	 * Set the user's password.
	 *
	 * @param password the password of the user.
	 */
	public void setPassword(String password);
	
	/**
	 * Is the user active?
	 *
	 * @return the user's status.
	 */
	public Boolean isActive();

	/**
	 * Set the user's status.
	 *
	 * @param active the status of the user.
	 */
	public void setActive(Boolean active);
	
	/**
	 * Get the registration date of the user.
	 * 
	 * @return The registration date of the user.
	 */
	public DateTime getRegistrationDate();
	
	/**
	 * Set the registration date of the user.
	 * 
	 * @param registrationDate the date of registration.
	 */
	public void setRegistrationDate(DateTime registrationDate);
	
	/**
	 * Get the user's basket.
	 * 
	 * @return the user's basket
	 */
	public List<Track> getBasket();
	
	/**
	 * Set the user's basket.
	 * 
	 * @param basket the user's basket
	 */
	public void setBasket(List<Track> basket);
	
	/**
	 * Get the user's purchases.
	 * 
	 * @return the user's purchases
	 */
	public List<Purchase> getPurchases();
	
	/**
	 * Set the user's purchases.
	 * 
	 * @param purchases the user's purchases
	 */
	public void setPurchases(List<Purchase> purchases);
}
