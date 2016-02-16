package uk.ac.bham.cs.aam.model;

import org.joda.time.LocalDate;

public interface WorkDetail {
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
	public String getDescription();
	
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description);
	
	/**
	 * 
	 * @return
	 */
	public WorkAllocation getAllocation();
	
	/**
	 * 
	 * @param allocation
	 */
	public void setAllocation(WorkAllocation allocation);
}
