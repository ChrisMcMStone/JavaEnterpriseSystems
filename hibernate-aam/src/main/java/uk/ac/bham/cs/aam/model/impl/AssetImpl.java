package uk.ac.bham.cs.aam.model.impl;

import java.util.Set;

import uk.ac.bham.cs.aam.model.Asset;
import uk.ac.bham.cs.aam.model.AssetType;
import uk.ac.bham.cs.aam.model.Work;

public class AssetImpl implements Asset {

	private String name;
	private AssetType assetType;
	private Integer version;
	private Integer id;
	private Integer number;

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
	public AssetType getAssetType() {
		return this.assetType;
	}

	@Override
	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
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
	public Integer getNumber() {
		return this.number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public Set<Work> getWork() {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

	@Override
	public void setWork(Set<Work> work) {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}
}
