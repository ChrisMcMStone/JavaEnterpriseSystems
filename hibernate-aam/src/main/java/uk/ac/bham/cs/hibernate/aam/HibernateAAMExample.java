package uk.ac.bham.cs.hibernate.aam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import uk.ac.bham.cs.aam.AAMExample;
import uk.ac.bham.cs.aam.model.AssetType;
import uk.ac.bham.cs.aam.model.impl.AssetTypeImpl;
import uk.ac.bham.cs.hibernate.HibernateService;

public class HibernateAAMExample implements HibernateService, AAMExample {
	/**
	 * 
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param sessionFactory
	 */
	public HibernateAAMExample(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<AssetType> getAssetTypes() {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			List<AssetType> assetTypes =
					session
						.createCriteria(AssetTypeImpl.class)
						.list();
			
			tx.commit();
			
			return new HashSet<AssetType>(assetTypes);
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addAssetType(String name) throws IllegalArgumentException {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			AssetType assetType = new AssetTypeImpl();
			assetType.setName(name);
			
			session.save(assetType);
			
			tx.commit();
		} catch(ConstraintViolationException e) {
			throw new IllegalArgumentException("An asset type with name `" + name + "' already exists.");
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			
			throw new RuntimeException(e);
		}
	}

	@Override
	public AssetType getAssetType(String name) throws IllegalArgumentException {
		Session session = this.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			AssetType assetType = (AssetType) session
					.createCriteria(AssetTypeImpl.class)
					.add(Restrictions.eq("name", name))
					.uniqueResult();
			tx.commit();
			return assetType;
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			
			throw new RuntimeException(e);
		}
	}
}
