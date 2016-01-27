package uk.ac.bham.cs.jdbc.music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;

import uk.ac.bham.cs.music.MusicServiceExercise;
import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;
import uk.ac.bham.cs.music.model.impl.PurchaseImpl;
import uk.ac.bham.cs.music.model.impl.UserImpl;

/**
 * The exercise for JDBC.
 */
public class JdbcExercise extends JdbcClassTestSolution implements MusicServiceExercise {
	/**
	 * Setup service.
	 * 
	 * We're using inheritance now!
	 * 
	 * @param db
	 */
	public JdbcExercise(Connection db) {
		super(db);
	}

	@Override
	public User getUser(String username) throws IllegalArgumentException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			stmt = this.getConnection().prepareStatement("SELECT * FROM users where username = ?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserImpl();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setActive(rs.getBoolean(5));
				user.setRegistrationDate(new DateTime(rs.getDate(6).getTime()));
				return user;
			}
			throw new IllegalArgumentException("User doesn't exist");
		} catch (SQLException e) {
			// we have an issue, time to go.
			throw new IllegalArgumentException(e);
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}

				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				// we have an issue, time to go.
				throw new IllegalArgumentException(e);
			}
		}
	}

	@Override
	public List<Purchase> getPurchases(User user) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Purchase> purchases = new ArrayList<Purchase>();
		try {
			psmt = getConnection().prepareStatement("SELECT id, purchase_date, price FROM purchase WHERE user_id = ?");
			psmt.setInt(1, user.getId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				Purchase purchase = new PurchaseImpl();
				purchase.setId(rs.getInt(1));
				purchase.setUser(user);
				purchase.setPurchaseDate(new DateTime(rs.getDate(2).getTime()));
				purchase.setPrice(rs.getDouble(3));
				purchase.setTracks(getTracksByPurchaseID(purchase.getId()));
				purchases.add(purchase);
			}
			return purchases;
		} catch (SQLException e) {
			// we have an issue, time to go.
			throw new IllegalArgumentException(e);
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (psmt != null && !psmt.isClosed()) {
					psmt.close();
				}
			} catch (SQLException e) {
				// we have an issue, time to go.
				throw new IllegalArgumentException(e);
			}
		}
	}

	public List<Track> getTracksByPurchaseID(int purchaseID) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Track> tracks = new ArrayList<Track>();
		try {
			psmt = getConnection().prepareStatement("SELECT track_id FROM purchase_track WHERE purchase_id = ?");
			psmt.setInt(1, purchaseID);
			rs = psmt.executeQuery();
			JdbcClassTestSolution service = new JdbcClassTestSolution(getConnection());
			while (rs.next()) {
				tracks.add(service.getTrackById(rs.getInt(1)));
			}
			return tracks;
		} catch (SQLException e) {
			// we have an issue, time to go.
			throw new IllegalArgumentException(e);
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (psmt != null && !psmt.isClosed()) {
					psmt.close();
				}
			} catch (SQLException e) {
				// we have an issue, time to go.
				throw new IllegalArgumentException(e);
			}
		}

	}

	@Override
	public void addToBasket(User user, Track track) throws IllegalArgumentException {
		PreparedStatement psmt = null;
		try {
			psmt = getConnection().prepareStatement("INSERT INTO user_basket VALUES (?, ?)");
			psmt.setInt(1, user.getId());
			psmt.setInt(2, track.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// we have an issue, time to go.
			if (e.getSQLState().equals("23505"))
				System.err.println("User already has that track in their basket");
			throw new IllegalArgumentException(e);
		} finally {
			try {
				if (psmt != null && !psmt.isClosed()) {
					psmt.close();
				}
			} catch (SQLException e) {
				// we have an issue, time to go.
				throw new IllegalArgumentException(e);
			}
		}
	}

	@Override
	public void purchase(User user) {
		PreparedStatement psmtRead = null;
		PreparedStatement psmtWritePurchase = null;
		PreparedStatement psmtWritePurchaseTrack = null;
		PreparedStatement psmtDelete = null;
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Integer> tracks = new ArrayList<>();
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			psmtRead = conn.prepareStatement("SELECT track_id FROM user_basket WHERE user_id = ?");
			psmtRead.setInt(1, user.getId());
			rs = psmtRead.executeQuery();
			while (rs.next()) {
				tracks.add(rs.getInt(1));
			}
			//psmtRead.close();
			if (tracks.size() != 0) {
				StringBuilder writeSQL = new StringBuilder(
						"INSERT INTO purchase_track (purchase_id, track_id) VALUES ");
				for (int i = 0; i < tracks.size(); i++) {
					writeSQL.append("((SELECT currval('purchase_id_seq')), " + tracks.get(i) + ")");
					if (i < tracks.size() - 1) {
						writeSQL.append(", ");
					}
				}
				System.out.println(writeSQL.toString());
				psmtWritePurchaseTrack = conn.prepareStatement(writeSQL.toString());
				psmtWritePurchase = conn
						.prepareStatement("INSERT INTO purchase (user_id, purchase_date, price) VALUES (?, ?, ?)");
				psmtWritePurchase.setInt(1, user.getId());
				psmtWritePurchase.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
				psmtWritePurchase.setDouble(3, 12.43); // Fixed price as tracks
														// don't have a price
														// (mistake by john?)

				psmtDelete = conn.prepareStatement("DELETE FROM user_basket WHERE user_id = ?");
				psmtDelete.setInt(1, user.getId());

				psmtWritePurchase.executeUpdate();
				psmtWritePurchaseTrack.executeUpdate();
				psmtDelete.executeUpdate();
				conn.commit();
				conn.setAutoCommit(true);
			} else {
				throw new IllegalArgumentException("User has no tracks in basket.");
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException s) {
				System.err.println(s.getMessage());
			}
			throw new IllegalArgumentException(e);
		} finally {
			try {
				if (psmtWritePurchase != null && !psmtWritePurchase.isClosed()) {
					psmtWritePurchase.close();
				}
				if (psmtWritePurchaseTrack != null && !psmtWritePurchaseTrack.isClosed()) {
					psmtWritePurchaseTrack.close();
				}
				if (psmtDelete != null && !psmtDelete.isClosed()) {
					psmtDelete.close();
				}
				if (psmtRead != null && !psmtRead.isClosed()) {
					psmtRead.close();
				}
			} catch (SQLException e) {
				// we have an issue, time to go.
				throw new IllegalArgumentException(e);
			}
		}
	}
}
