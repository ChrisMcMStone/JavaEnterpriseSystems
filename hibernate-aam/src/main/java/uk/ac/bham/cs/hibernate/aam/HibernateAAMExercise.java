package uk.ac.bham.cs.hibernate.aam;

import java.util.Set;

import org.hibernate.SessionFactory;

import uk.ac.bham.cs.aam.AAMExercise;
import uk.ac.bham.cs.aam.model.Asset;

public class HibernateAAMExercise extends HibernateAAMExample implements AAMExercise {

	public HibernateAAMExercise(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public void updateAssetType(String oldName, String newName)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

	@Override
	public void deleteAssetType(String name) throws IllegalArgumentException {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

	@Override
	public Set<Asset> getAssets(Integer start, Integer end)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

	@Override
	public void addAsset(Integer assetNumber, String name, String assetType)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

	@Override
	public void updateAsset(Integer assetNumber, Integer newAssetNumber,
			String newName, String newAssetType)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

	@Override
	public void deleteAssetRange(Integer start, Integer end)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("You'll need to do this one :).");
	}

}
