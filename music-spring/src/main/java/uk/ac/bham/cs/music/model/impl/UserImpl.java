package uk.ac.bham.cs.music.model.impl;

import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;
import uk.ac.bham.cs.music.model.User;

public class UserImpl implements User {
	
	private Integer id;
	private String name;
	private String username;
	private String password;
	private Boolean active;
	private LocalDateTime registrationTime;
	private Set<Track> basket;
	private Set<Purchase> purchases;
	

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Boolean isActive() {
		return active;
	}

	@Override
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public Set<Track> getBasket() {
		return basket;
	}

	@Override
	public void setBasket(Set<Track> basket) {
		this.basket = basket;
	}

	@Override
	public Set<Purchase> getPurchases() {
		return purchases;
	}

	@Override
	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public LocalDateTime getRegistrationTime() {
		return this.registrationTime;
	}

	@Override
	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}

}
