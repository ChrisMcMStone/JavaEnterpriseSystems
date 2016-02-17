package uk.ac.bham.cs.aam.model.impl;

import java.util.Set;

import uk.ac.bham.cs.aam.model.Customer;
import uk.ac.bham.cs.aam.model.Work;

public class CustomerImpl implements Customer {
	
	private Integer id;
	private Integer version;
	private String firstName;
	private String lastName;
	private String email;
	private Set<Work> work;
	private String address;

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
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public Set<Work> getWork() {
		return work;
	}
	
	@Override
	public void setWork(Set<Work> work) {
		this.work = work;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		return this.email.equals(((Customer) obj).getEmail());
	}
}
