package com.neogrowth.catalog.model.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Store composite key of {@link GenreMovie} 
 * @author Ashish
 * @since Aug 15, 2017
 */
@Embeddable
public class GenreMoviePK implements Serializable {

	private static final long serialVersionUID = 1394385286341946525L;

	@Column(name="movie")
	private int movieId;
	
	@Column(name="genre")
	private int genreId;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
}