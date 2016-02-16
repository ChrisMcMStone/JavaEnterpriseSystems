package uk.ac.bham.cs.aam;

import java.util.Set;

import uk.ac.bham.cs.aam.model.Asset;

public interface AAMExercise extends AAMExample {
	/**
	 * Update the name of an asset type.
	 * 
	 * @param oldName the old name
	 * @param newName the new name
	 * @throws IllegalArgumentException if old name doesn't exist or if new name already exists.
	 */
	public void updateAssetType(String oldName, String newName) throws IllegalArgumentException;
	
	/**
	 * Delete an asset type.
	 * 
	 * @param name the name of the asset type
	 * @throws IllegalArgumentException a constraint violation or name doesn't exist. 
	 */
	public void deleteAssetType(String name) throws IllegalArgumentException;
	
	/**
	 * Get a range of assets.
	 * 
	 * @param start that starting asset number
	 * @param end   the final asset number
	 * @return The set of assets with assetNumber >= start and assetNumber <= end
	 * @throws IllegalArgumentException if start > end
	 */
	public Set<Asset> getAssets(Integer start, Integer end) throws IllegalArgumentException;
	
	/**
	 * Add a new asset.
	 * 
	 * Hint: read below for constraints.
	 * 
	 * @param assetNumber the number of the asset (not the id)
	 * @param name the name of the asset
	 * @param assetType the name of the asset type.
	 * @throws IllegalArgumentException if assetType doesn't exist or if name or assetNumber already exists.
	 */
	public void addAsset(Integer assetNumber, String name, String assetType) throws IllegalArgumentException;
	
	/**
	 * Update an asset.
	 * 
	 * @param assetNumber the number of the asset (not the id)
	 * @param newAssetNumber the new number of the asset
	 * @param newName the new name
	 * @param newAssetType the new asset type
	 * @throws IllegalArgumentException if assetType doesn't exist or if the newAssetNumber of newAssetName already exists.
	 */
	public void updateAsset(Integer assetNumber, Integer newAssetNumber, String newName, String newAssetType) throws IllegalArgumentException;
	
	/**
	 * Delete all assets within a given range.
	 * 
	 * @param start that starting asset number
	 * @param end   the final asset number
	 * @throws IllegalArgumentException if start > end
	 */
	public void deleteAssetRange(Integer start, Integer end) throws IllegalArgumentException;
}
