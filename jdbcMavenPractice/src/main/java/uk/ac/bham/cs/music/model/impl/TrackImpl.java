package uk.ac.bham.cs.music.model.impl;

import java.util.List;

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
	
	/**
	 *  Track Album
	 */
	private Album album;
	
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
	public Album getAlbum() {
		return this.album;
	}
	
	@Override
	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public List<Purchase> getPurchases() {
		throw new UnsupportedOperationException("");
	}

	@Override
	public void setPurchases(List<Purchase> purchasedBy) {
		throw new UnsupportedOperationException("");
	}
}
