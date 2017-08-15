package com.neogrowth.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neogrowth.catalog.dao.MovieDao;
import com.neogrowth.catalog.model.persistence.Movie;
import com.neogrowth.catalog.service.MovieService;

/**
 * Implemented {@link MovieService} and defined its method
 * @author Ashish
 * @since Aug 14, 2017
 */
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;
	
	/**
	 * Save {@link Movie} in the database
	 * param movie
	 * return {@link Movie}
	 */
	@Override
	public Movie save(Movie movie) {
		return movieDao.save(movie);
	}

	/**
	 * Search list of {@link Movie} using name and with given limit
	 * param name
	 * param limit
	 * return list of {@link Movie}
	 */
	@Override
	public List<Movie> search(String name, int limit) {
		return movieDao.search(name, limit);
	}

	/**
	 * Get list of {@link Movie} sorted by rating
	 * param limit
	 * return list of {@link Movie}
	 */
	@Override
	public List<Movie> getByRating(int limit) {
		return movieDao.getByRating(limit);
	}

	/**
	 * Get list of {@link Movie} with the given limit
	 * param limit
	 * return list of {@link Movie}
	 */
	@Override
	public List<Movie> getAll(int limit) {
		return movieDao.getAll(limit);
	}

	/**
	 * Get the page count of the {@link Movie}
	 * return long
	 */
	@Override
	public long getCount() {
		return movieDao.getCount();
	}
}
