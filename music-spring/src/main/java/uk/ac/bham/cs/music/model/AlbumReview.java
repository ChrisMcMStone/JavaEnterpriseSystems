package uk.ac.bham.cs.music.model;

public interface AlbumReview {
	
	public Integer getId();
	public void setId(Integer id);
	public String getReview();
	public void setReview(String review);
	public User getUser();
	public void setUser(User user);
	public Album getAlbum();
	public void setAlbum(Album album);
}
