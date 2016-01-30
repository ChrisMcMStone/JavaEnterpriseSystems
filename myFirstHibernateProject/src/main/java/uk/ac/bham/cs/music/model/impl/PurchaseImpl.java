package uk.ac.bham.cs.music.model.impl;

import java.util.Set;

import org.joda.time.LocalTime;

import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;

public class PurchaseImpl implements Purchase {

	private Integer id;
	private LocalTime purchaseDate;
	private User user;
	private Set<Track> tracks;
	private Double price;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public LocalTime getPurchaseDate() {
		return purchaseDate;
	}

	@Override
	public void setPurchaseDate(LocalTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Set<Track> getTracks() {
		return tracks;
	}

	@Override
	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public void setPrice(Double price) {
		this.price = price;
	}

}
