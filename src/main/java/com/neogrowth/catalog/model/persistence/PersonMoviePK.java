package com.neogrowth.catalog.model.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Store composite key of {@link PersonMovie} 
 * @author Ashish
 * @since Aug 15, 2017
 */
@Embeddable
public class PersonMoviePK implements Serializable {

	private static final long serialVersionUID = 4612873395837130369L;

	@Column(name="movie")
	private int movieId;
	
	@Column(name="person")
	private int personId;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
}
