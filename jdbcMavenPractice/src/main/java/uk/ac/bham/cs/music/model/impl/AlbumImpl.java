package uk.ac.bham.cs.music.model.impl;

import java.util.List;

import org.joda.time.LocalDate;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Track;

public class AlbumImpl implements Album {

	private List<Track> tracks;
	private Double price;
	private Artist artist;
	private LocalDate releaseDate;
	private String name;
	private Integer id;

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
	public LocalDate getReleaseDate() {
		return this.releaseDate;
	}

	@Override
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public Artist getArtist() {
		return this.artist;
	}

	@Override
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public List<Track> getTracks() {
		return this.tracks;
	}

	@Override
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
