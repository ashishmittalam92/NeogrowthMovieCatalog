package com.neogrowth.catalog.service;

import com.neogrowth.catalog.model.persistence.GenreMovie;

/**
 * Declare service method of {@link GenreMovie}
 * @author Ashish
 * @since Aug 15, 2017
 */
public interface GenreMovieService {
	public GenreMovie save(GenreMovie genreMovie);
	public GenreMovie getById(int id);
}
