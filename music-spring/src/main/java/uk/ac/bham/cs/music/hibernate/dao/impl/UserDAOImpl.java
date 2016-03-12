package uk.ac.bham.cs.music.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import uk.ac.bham.cs.music.dao.UserDAO;
import uk.ac.bham.cs.music.model.User;
import uk.ac.bham.cs.music.model.impl.UserImpl;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(User user) {
		this.getSessionFactory().getCurrentSession().save(user);
	}

	@Override
	public User getById(Integer id) {
		return this.getSessionFactory().getCurrentSession().get(UserImpl.class, id);
	}

	@Override
	public User getByUsername(String name) {
		return (User) this.getSessionFactory().getCurrentSession()
				.createCriteria(UserImpl.class)
				.add(Restrictions.eq("username", name)).uniqueResult();
	}

}
