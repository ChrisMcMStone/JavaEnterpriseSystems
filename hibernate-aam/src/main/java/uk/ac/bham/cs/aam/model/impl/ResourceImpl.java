package uk.ac.bham.cs.aam.model.impl;

import java.util.Set;

import uk.ac.bham.cs.aam.model.AssetType;
import uk.ac.bham.cs.aam.model.Resource;
import uk.ac.bham.cs.aam.model.WorkAllocation;

public class ResourceImpl implements Resource {

	private Integer id;
	private Integer version;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private Set<WorkAllocation> allocations;
	private AssetType assetType;

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
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
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
	public Set<WorkAllocation> getAllocations() {
		return allocations;
	}

	@Override
	public void setAllocations(Set<WorkAllocation> allocations) {
		this.allocations = allocations;
	}

	@Override
	public AssetType getAssetType() {
		return assetType;
	}

	@Override
	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	@Override
	public boolean equals(Object obj) {
		return this.email.equals(((Resource) obj).getEmail());
	}
}
