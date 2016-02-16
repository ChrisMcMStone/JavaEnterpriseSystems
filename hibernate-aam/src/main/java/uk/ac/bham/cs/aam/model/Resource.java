package uk.ac.bham.cs.aam.model;

import java.util.Set;

public interface Resource {
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
	public String getFirstName();
	
	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName);
	
	/**
	 * 
	 * @return
	 */
	public String getLastName();
	
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName);
	
	/**
	 * 
	 * @return
	 */
	public String getAddress();
	
	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address);
	
	/**
	 * 
	 * @return
	 */
	public String getEmail();
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email);
	
	/**
	 * 
	 * @return
	 */
	public Set<WorkAllocation> getAllocations();
	
	/**
	 * 
	 * @param allocations
	 */
	public void setAllocations(Set<WorkAllocation> allocations);
	
	/**
	 * 
	 * @return
	 */
	public AssetType getAssetType();
	
	/**
	 * 
	 * @param assetType
	 */
	public void setAssetType(AssetType assetType);
}
