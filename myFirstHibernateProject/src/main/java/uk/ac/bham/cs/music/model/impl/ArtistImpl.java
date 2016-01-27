package uk.ac.bham.cs.music.model.impl;

import java.util.Set;

import org.joda.time.LocalDate;

import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;

public class ArtistImpl implements Artist {
	private Integer id;
	private String name;
	private LocalDate formationDate;
	private LocalDate disbandmentDate;
	private Set<Album> albums;

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
	public LocalDate getFormationDate() {
		return this.formationDate;
	}

	@Override
	public void setFormationDate(LocalDate formationDate) {
		this.formationDate = formationDate;
	}

	@Override
	public LocalDate getDisbandmentDate() {
		return this.disbandmentDate;
	}

	@Override
	public void setDisbandmentDate(LocalDate disbandmentDate) {
		this.disbandmentDate = disbandmentDate;
	}

	@Override
	public Set<Album> getAlbums() {
		return this.albums;
	}

	@Override
	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}
}
