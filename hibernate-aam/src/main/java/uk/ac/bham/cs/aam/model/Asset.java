package uk.ac.bham.cs.aam.model;

import java.util.Set;

public interface Asset {
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
	public Integer getNumber();
	
	/**
	 * 
	 * @param assetNumber
	 */
	public void setNumber(Integer number);
	
	/**
	 * 
	 * @return
	 */
	public AssetType getAssetType();
	
	/**
	 * 
	 * @param version
	 */
	public void setAssetType(AssetType assetType);
	
	/**
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * 
	 * @return
	 */
	public Set<Work> getWork();
	
	/**
	 * 
	 * @param work
	 */
	public void setWork(Set<Work> work);
}
