package uk.ac.bham.cs.music.hibernate.dao.impl;

import org.hibernate.SessionFactory;

import uk.ac.bham.cs.music.dao.PurchaseDAO;
import uk.ac.bham.cs.music.model.Purchase;

public class PurchaseDAOImpl implements PurchaseDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Purchase purchase) {
		this.getSessionFactory().getCurrentSession().save(purchase);
	}

}
