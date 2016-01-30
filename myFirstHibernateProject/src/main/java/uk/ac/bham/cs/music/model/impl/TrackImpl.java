package uk.ac.bham.cs.music.model.impl;

import java.util.Set;

import org.joda.time.Duration;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Purchase;
import uk.ac.bham.cs.music.model.Track;

public class TrackImpl implements Track {
	/**
	 * Track ID
	 */
	private Integer id;
	
	/**
	 * Track title
	 */
	private String title;
	
	/**
	 * Track length.
	 */
	private Duration length;
	
	private Double price;
	/**
	 *  Track Album
	 */
	private Set<Album> albums;
	
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
	public String getTitle() {
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public Duration getLength() {
		return this.length;
	}

	@Override
	public void setLength(Duration length) {
		this.length = length;
	}

	@Override
	public Set<Album> getAlbums() {
		return this.albums;
	}
	
	@Override
	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
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
	public Double getPrice() {
		return price;
	}

	@Override
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
