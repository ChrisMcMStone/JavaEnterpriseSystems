package uk.ac.bham.cs.aam.model.impl;

import org.joda.time.LocalDate;

import uk.ac.bham.cs.aam.model.Asset;
import uk.ac.bham.cs.aam.model.Customer;
import uk.ac.bham.cs.aam.model.Work;

public class WorkImpl implements Work {

	private Integer id;
	private Integer version;
	private Customer customer;
	private LocalDate startDate;
	private LocalDate completionDate;
	private Asset asset;
	
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
	public Customer getCustomer() {
		return customer;
	}
	
	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	public Asset getAsset() {
		return asset;
	}
	
	@Override
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
}
