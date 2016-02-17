package uk.ac.bham.cs.aam.model.impl;

import org.joda.time.LocalDate;

import uk.ac.bham.cs.aam.model.WorkAllocation;
import uk.ac.bham.cs.aam.model.WorkDetail;

public class WorkDetailImpl implements WorkDetail {
	
	private Integer id;
	private Integer version;
	private LocalDate startDate;
	private LocalDate completionDate;
	private String description;
	private WorkAllocation allocation;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public Integer getVersion() {
		return version;
	}
	
	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Override
	public LocalDate getStartDate() {
		return startDate;
	}
	
	@Override
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public LocalDate getCompletionDate() {
		return completionDate;
	}
	
	@Override
	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public WorkAllocation getAllocation() {
		return allocation;
	}
	
	@Override
	public void setAllocation(WorkAllocation allocation) {
		this.allocation = allocation;
	}

}
