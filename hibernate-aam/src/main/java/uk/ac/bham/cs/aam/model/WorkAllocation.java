package uk.ac.bham.cs.aam.model;

import java.util.Set;

import org.joda.time.LocalDate;

public interface WorkAllocation {
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
	public Set<WorkDetail> getDetails();
	
	/**
	 * 
	 * @param details
	 */
	public void setDetails(Set<WorkDetail> details);
	
	/**
	 * 
	 * @return
	 */
	public Work getWork();
	
	/**
	 * 
	 * @param work
	 */
	public void setWork(Work work);
	
	/**
	 * 
	 * @return
	 */
	public Resource getResource();
	
	/**
	 * 
	 * @param resource
	 */
	public void setResource(Resource resource);
}
