package uk.ac.bham.cs.music.model.impl;

import java.util.List;

import org.joda.time.DateTime;

import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;

public class PurchaseImpl implements Purchase {
	
	private int id;
	private DateTime purchaseDate;
	private User user;
	private List<Track> tracks;
	private double price;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public DateTime getPurchaseDate() {
		return purchaseDate;
	}

	@Override
	public void setPurchaseDate(DateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public User getUser() {
		return this.user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public List<Track> getTracks() {
		return this.tracks;
	}

	@Override
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

}
