package com.neogrowth.catalog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neogrowth.catalog.dao.GenreMovieDao;
import com.neogrowth.catalog.model.persistence.GenreMovie;
import com.neogrowth.catalog.repository.GenreMovieRepository;

/**
 * This is implementation of {@link GenreMovieDao} and define the method 
 * @author Ashish
 * @since Aug 15, 2017
 */
@Repository
public class GenreMovieDaoImpl implements GenreMovieDao {

	@Autowired
	private GenreMovieRepository genreMovieRepository;
	
	/**
	 * Save genreMovie object in database
	 * param genreMovie
	 * return {@link GenreMovie}
	 */
	@Override
	public GenreMovie save(GenreMovie genreMovie) {
		return genreMovieRepository.save(genreMovie);
	}

	/**
	 * Find genre movie using id
	 * param id
	 * return {@link GenreMovie}
	 */
	@Override
	public GenreMovie getById(int id) {
		return genreMovieRepository.findOne(id);
	}	
}
