package uk.ac.bham.cs.aam.model;

import org.joda.time.LocalDate;

public interface Work {
	/**
	 * 
	 * @return
	 */
	public Integer getId();
	
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id);
	
	/**
	 * 
	 * @return
	 */
	public Integer getVersion();
	
	/**
	 * 
	 * @param version
	 */
	public void setVersion(Integer version);
	
	/**
	 * 
	 * @return
	 */
	public Customer getCustomer();
	
	/**
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer);
	
	/**
	 * 
	 * @return
	 */
	public LocalDate getStartDate();
	
	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(LocalDate startDate);
	
	/**
	 * 
	 * @return
	 */
	public LocalDate getCompletionDate();
	
	/**
	 * 
	 * @param completionDate
	 */
	public void setCompletionDate(LocalDate completionDate);
	
	/**
	 * 
	 * @return
	 */
	public Asset getAsset();
	
	/**
	 * 
	 * @param asset
	 */
	public void setAsset(Asset asset);
}
