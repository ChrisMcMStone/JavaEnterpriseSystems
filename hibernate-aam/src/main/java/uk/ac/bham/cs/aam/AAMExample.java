package uk.ac.bham.cs.aam;

import java.util.Set;

import uk.ac.bham.cs.aam.model.AssetType;

public interface AAMExample {
	/**
	 * Retrieve all asset types.
	 * 
	 * @return The asset types;
	 */
	public Set<AssetType> getAssetTypes();
	
	/**
	 * Add a new asset type.
	 * 
	 * @param name The name of the new asset type.
	 * @throws IllegalArgumentException if name already exists.
	 */
	public void addAssetType(String name) throws IllegalArgumentException;
	
	/**
	 * Get an asset type by its name.
	 * 
	 * @param name The asset type's name.
	 * @return The asset type requested.
	 * @throws IllegalArgumentException if name doesn't exist.
	 */
	public AssetType getAssetType(String name) throws IllegalArgumentException;
}
