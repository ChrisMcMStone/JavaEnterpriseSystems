package uk.ac.bham.cs.aam.model;

import java.util.Set;

public interface AssetType {
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
	public Set<Asset> getAssets();
	
	/**
	 * 
	 * @param version
	 */
	public void setAssets(Set<Asset> assets);
	
	/**
	 * 
	 * @return
	 */
	public Set<Resource> getResources();
	
	/**
	 * 
	 * @param resources
	 */
	public void setResources(Set<Resource> resources);
}
