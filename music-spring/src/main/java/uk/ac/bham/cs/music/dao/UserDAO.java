package uk.ac.bham.cs.music.dao;

import uk.ac.bham.cs.music.model.User;

public interface UserDAO {
	/**
	 * 
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * 
	 * @param id
	 */
	public User getById(Integer id);
	
	/**
	 * 
	 * @param name
	 */
	public User getByUsername(String name);
}
