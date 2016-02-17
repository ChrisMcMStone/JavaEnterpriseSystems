package uk.ac.bham.cs.aam.model.impl;

import java.util.Set;

import org.joda.time.LocalDate;

import uk.ac.bham.cs.aam.model.Resource;
import uk.ac.bham.cs.aam.model.Work;
import uk.ac.bham.cs.aam.model.WorkAllocation;
import uk.ac.bham.cs.aam.model.WorkDetail;

public class WorkAllocationImpl implements WorkAllocation {
	
	private Integer id;
	private Integer version;
	private LocalDate startDate;
	private LocalDate completionDate;
	private String description;
	private Set<WorkDetail> details;
	private Work work;
	private Resource resource;
	
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
	public Set<WorkDetail> getDetails() {
		return details;
	}
	
	@Override
	public void setDetails(Set<WorkDetail> details) {
		this.details = details;
	}
	
	@Override
	public Work getWork() {
		return work;
	}
	
	@Override
	public void setWork(Work work) {
		this.work = work;
	}
	
	@Override
	public Resource getResource() {
		return resource;
	}
	
	@Override
	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
