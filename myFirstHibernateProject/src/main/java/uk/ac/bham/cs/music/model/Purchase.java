package uk.ac.bham.cs.music.model;

import java.util.Set;

import org.joda.time.LocalDate;

public interface Purchase {
	/**
	 * Get the purchase's ID.
	 *
	 * @return the purchase's ID
	 */
	public Integer getId();

	/**
	 * Set the purchase's ID.
	 *
	 * @param id the ID of the purchase.
	 */
	public void setId(Integer id);
	
	/**
	 * Get the purchase date.
	 * 
	 * @return The purchase date.
	 */
	public LocalDate getPurchaseDate();
	
	/**
	 * Set the purchase date.
	 * 
	 * @param purchaseDate the date of registration.
	 */
	public void setPurchaseDate(LocalDate purchaseDate);
	
	/**
	 * Get the buyer.
	 * 
	 * @return The user that purchased this order.
	 */
	public User getUser();
	
	/**
	 * Set the buyer.
	 * 
	 * @param user The user this purchase relates to.
	 */
	public void setUser(User user);
	
	/**
	 * Get the tracks that were purchased.
	 * 
	 * @return The tracks that were purchased.
	 */
	public Set<Track> getTracks();
	
	/**
	 * Get the tracks that were purchased.
	 * 
	 * @param tracks The tracks that were purchased.
	 */
	public void setTracks(Set<Track> tracks);
	
	public Double getPrice();
	public void setPrice(Double price);
}
