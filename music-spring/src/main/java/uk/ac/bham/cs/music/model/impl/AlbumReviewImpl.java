package uk.ac.bham.cs.music.model.impl;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.AlbumReview;
import uk.ac.bham.cs.music.model.User;

public class AlbumReviewImpl implements AlbumReview {
	
	private Integer id;
	private String review;
	private User user;
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
	public String getReview() {
		return review;
	}

	@Override
	public void setReview(String review) {
		this.review = review;
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
	public Album getAlbum() {
		return album;
	}

	@Override
	public void setAlbum(Album album) {
		this.album = album;

	}

}
