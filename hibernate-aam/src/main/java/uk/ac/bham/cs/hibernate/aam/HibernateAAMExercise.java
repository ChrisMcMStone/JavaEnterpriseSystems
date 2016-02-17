package uk.ac.bham.cs.hibernate.aam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import uk.ac.bham.cs.aam.AAMExercise;
import uk.ac.bham.cs.aam.model.Asset;
import uk.ac.bham.cs.aam.model.AssetType;
import uk.ac.bham.cs.aam.model.impl.AssetImpl;

public class HibernateAAMExercise extends HibernateAAMExample implements AAMExercise {

	public HibernateAAMExercise(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public void updateAssetType(String oldName, String newName) throws IllegalArgumentException {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Query query = session.createQuery("from AssetTypeImpl where name = :name");
			query.setParameter("name", oldName);
			AssetType assetType = (AssetType)query.uniqueResult();
			assetType.setName(newName);
			session.save(assetType);
			
			tx.commit();
		} catch (ConstraintViolationException e) {
			throw new IllegalArgumentException("Asset type provided doesn't exist in database");
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteAssetType(String name) throws IllegalArgumentException {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Query query = session.createQuery("delete AssetTypeImpl where name = :name");
			query.setParameter("name", name);
			query.executeUpdate();
			tx.commit();
		} catch (ConstraintViolationException e) {
			throw new IllegalArgumentException("Asset type provided doesn't exist in database");
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Asset> getAssets(Integer start, Integer end) throws IllegalArgumentException {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			List<Asset> assets = null;
			Query query = null;
			if(start == null && end == null) {
				query = session.createQuery("from AssetImpl");
			} else if (end == null) {
				query = session.createQuery("from AssetImpl where number = :no");
				query.setParameter("no", start);
			} else if (start != null && end != null) {
				query = session.createQuery("from AssetImpl where number >= :start and number <= :end");
				query.setParameter("start", start);
				query.setParameter("end", end);
			}
			assets = query.list();
			tx.commit();
			return new HashSet<Asset>(assets);
		} catch (ConstraintViolationException e) {
			throw new IllegalArgumentException("Asset with given number or range doesn't exist.");
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void addAsset(Integer assetNumber, String name, String assetType)
			throws IllegalArgumentException {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Query query = session.createQuery("from AssetTypeImpl where name = :name");
			query.setParameter("name", assetType);
			AssetType type = (AssetType)query.uniqueResult();
			if(type == null)
				throw new IllegalArgumentException("AssetType " + assetType + " doesn't exist.");
			Asset asset = new AssetImpl();
			asset.setAssetType(type);
			asset.setNumber(assetNumber);
			asset.setName(name);
			session.save(asset);
			tx.commit();
		} catch (ConstraintViolationException e) {
			throw new IllegalArgumentException(e.getCause());
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
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
