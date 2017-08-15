package com.neogrowth.catalog.dao;

import com.neogrowth.catalog.model.persistence.GenreMovie;

/**
 * Declare all method of {@link GenreMovieDao} 
 * @author Ashish
 * @since Aug 15, 2017
 */
public interface GenreMovieDao {
	
	public GenreMovie save(GenreMovie genreMovie);
	
	public GenreMovie getById(int id);
}
