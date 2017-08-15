package com.neogrowth.catalog.model.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * JPA model of Genre table
 * @author Ashish
 * @since Aug 14, 2017
 */
@Entity
@Table(name="genre")
public class Genre implements Serializable {

	private static final long serialVersionUID = -3354534173628044335L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "genre")
    @JsonManagedReference
	private Set<GenreMovie> GenreMovie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<GenreMovie> getGenreMovie() {
		return GenreMovie;
	}

	public void setGenreMovie(Set<GenreMovie> genreMovie) {
		GenreMovie = genreMovie;
	}
}
