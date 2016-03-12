package uk.ac.bham.cs.music.hibernate;

import uk.ac.bham.cs.hibernate.HibernateService;
import uk.ac.bham.cs.music.MusicService;

public interface HibernateMusicService extends MusicService, HibernateService {
	
	public void addReview(String username, String artistName, String albumName, String review);

}
