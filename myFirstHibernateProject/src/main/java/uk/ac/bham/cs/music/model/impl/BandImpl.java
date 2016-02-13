package uk.ac.bham.cs.music.model.impl;

import java.util.Set;

import uk.ac.bham.cs.music.model.Artist;

public class BandImpl extends ArtistImpl {
	
	private String bandName;
	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	private Set<Artist> artists;

	public Set<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Set<Artist> artists) {
		this.artists = artists;
	}

}
