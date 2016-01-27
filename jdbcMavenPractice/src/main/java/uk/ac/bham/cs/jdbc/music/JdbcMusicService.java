package uk.ac.bham.cs.jdbc.music;

import java.sql.Connection;

import uk.ac.bham.cs.music.MusicService;

/**
 * A JDBC specific version of the Music Service.
 * 
 * @author John T. Saxon <j.t.saxon@cs.bham.ac.uk>
 */
public interface JdbcMusicService extends MusicService {
	/**
	 * Get the database connection.
	 *
	 * <strong>You might want to set this inside of the constructor. Pass it from main().</strong>
	 *
	 * @return a JDBC database connection.
	 */
	public Connection getConnection();
}
