package uk.ac.bham.cs.aam.model.impl;

import java.util.Set;

import uk.ac.bham.cs.aam.model.Asset;
import uk.ac.bham.cs.aam.model.AssetType;
import uk.ac.bham.cs.aam.model.Resource;

public class AssetTypeImpl implements AssetType {

	private Set<Asset> assets;
	private String name;
	private Integer version;
	private Integer id;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getVersion() {
		return this.version;
	}

	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Set<Asset> getAssets() {
		return this.assets;
	}

	@Override
	public void setAssets(Set<Asset> assets) {
		this.assets = assets;
	}

	@Override
	public Set<Resource> getResources() {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

	@Override
	public void setResources(Set<Resource> resources) {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

}
