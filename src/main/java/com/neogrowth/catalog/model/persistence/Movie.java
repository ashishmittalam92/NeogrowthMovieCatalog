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
 * JPA model of Movie table
 * @author Ashish
 * @since Aug 14, 2017
 */
@Entity
@Table(name="movie")
public class Movie implements Serializable {

	private static final long serialVersionUID = 4852625135004674761L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="release_year")
	private String releaseYear;
	
	@Column(name="imdb_rating")
	private String imdbRating;
	
	@OneToMany(mappedBy = "movie")
    @JsonManagedReference
	private Set<PersonMovie> personMovie;
	
	@OneToMany(mappedBy = "movie")
    @JsonManagedReference
	private Set<GenreMovie> genreMovie;
	
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
	
	public String getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Set<PersonMovie> getPersonMovie() {
		return personMovie;
	}

	public void setPersonMovie(Set<PersonMovie> personMovie) {
		this.personMovie = personMovie;
	}

	public Set<GenreMovie> getGenreMovie() {
		return genreMovie;
	}

	public void setGenreMovie(Set<GenreMovie> genreMovie) {
		this.genreMovie = genreMovie;
	}	
}
