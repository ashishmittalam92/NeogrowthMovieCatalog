package com.neogrowth.catalog.response;

import java.util.Set;

public class MovieResponse {

	private int id;
	private String name;
	private Set<String> actors;
	private Set<String> directors;
	private Set<String> genres;
	private String releaseYear;
	private String imdbRating;
	
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
	
	public Set<String> getActors() {
		return actors;
	}
	
	public void setActors(Set<String> actors) {
		this.actors = actors;
	}
	
	public Set<String> getDirectors() {
		return directors;
	}
	
	public void setDirectors(Set<String> directors) {
		this.directors = directors;
	}
	
	public Set<String> getGenres() {
		return genres;
	}

	public void setGenres(Set<String> genres) {
		this.genres = genres;
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
}