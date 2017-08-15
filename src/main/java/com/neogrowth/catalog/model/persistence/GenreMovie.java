package com.neogrowth.catalog.model.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * JPA Model of GenreMovie table
 * @author Ashish
 * @since Aug 15, 2017
 */
@Entity
@Table(name="genre_movie")
public class GenreMovie implements Serializable {

	private static final long serialVersionUID = 1394385286341946525L;

	@EmbeddedId
	private GenreMoviePK genreMoviePK;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @MapsId("movieId")
    @JoinColumn(name = "movie")
    @JsonBackReference
    private Movie movie;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("genreId")
    @JoinColumn(name = "genre")
    @JsonBackReference
    private Genre genre;

	public GenreMoviePK getGenreMoviePK() {
		return genreMoviePK;
	}

	public void setGenreMoviePK(GenreMoviePK genreMoviePK) {
		this.genreMoviePK = genreMoviePK;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
