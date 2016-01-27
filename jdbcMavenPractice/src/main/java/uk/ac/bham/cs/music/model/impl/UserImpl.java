package uk.ac.bham.cs.music.model.impl;

import java.util.List;

import org.joda.time.DateTime;

import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;

public class UserImpl implements uk.ac.bham.cs.music.model.User {
	
	private Integer id;
	private String name;
	private String username;
	private String password;
	private Boolean isActive;
	private DateTime registrationDate;
	private List<Track> basket;
	private List<Purchase> purchases;
	
	public UserImpl(){}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Boolean isActive() {
		return isActive;
	}

	@Override
	public void setActive(Boolean active) {
		this.isActive = active;
	}

	@Override
	public DateTime getRegistrationDate() {
		return this.registrationDate;
	}

	@Override
	public void setRegistrationDate(DateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public List<Track> getBasket() {
		return basket;
	}

	@Override
	public void setBasket(List<Track> basket) {
		this.basket = basket;
	}

	@Override
	public List<Purchase> getPurchases() {
		return purchases;
	}

	@Override
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}


}
