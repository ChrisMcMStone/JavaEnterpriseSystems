package uk.ac.bham.cs.music.model.impl;

import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;

public class PurchaseImpl implements Purchase {

	private Integer id;
	private LocalDateTime purchaseDate;
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
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	@Override
	public void setPurchaseDate(LocalDateTime purchaseDate) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
