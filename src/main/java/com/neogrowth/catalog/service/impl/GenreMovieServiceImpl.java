package com.neogrowth.catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neogrowth.catalog.dao.GenreMovieDao;
import com.neogrowth.catalog.model.persistence.GenreMovie;
import com.neogrowth.catalog.service.GenreMovieService;

/**
 * Implemented {@link GenreMovieService} and defined its method
 * @author Ashish
 * @since Aug 15, 2017
 */
@Service
public class GenreMovieServiceImpl implements GenreMovieService {

	@Autowired
	private GenreMovieDao genreMovieDao;
	
	/**
	 * Save {@link GenreMovie} in the database
	 * param genreMovie
	 * return {@link GenreMovie}
	 */
	@Override
	public GenreMovie save(GenreMovie genreMovie) {
		return genreMovieDao.save(genreMovie);
	}

	/**
	 * Find {@link GenreMovie} using id
	 * param id
	 * return {@link GenreMovie}
	 */
	@Override
	public GenreMovie getById(int id) {
		return genreMovieDao.getById(id);
	}
}
