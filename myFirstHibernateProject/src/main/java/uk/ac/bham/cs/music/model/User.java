package uk.ac.bham.cs.music.model;

import java.util.Set;
import org.joda.time.LocalDate;

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
	 * Get the registration time of the user.
	 * 
	 * @return The registration time of the user.
	 */
	public LocalDate getRegistrationDate();
	
	/**
	 * Set the registration time of the user.
	 * 
	 * @param registrationTime the time of registration.
	 */
	public void setRegistrationDate(LocalDate registrationDate);
	
	/**
	 * Get the user's basket.
	 * 
	 * @return the user's basket
	 */
	public Set<Track> getBasket();
	
	/**
	 * Set the user's basket.
	 * 
	 * @param basket the user's basket
	 */
	public void setBasket(Set<Track> basket);
	
	/**
	 * Get the user's purchases.
	 * 
	 * @return the user's purchases
	 */
	public Set<Purchase> getPurchases();
	
	/**
	 * Set the user's purchases.
	 * 
	 * @param purchases the user's purchases
	 */
	public void setPurchases(Set<Purchase> purchases);

}
