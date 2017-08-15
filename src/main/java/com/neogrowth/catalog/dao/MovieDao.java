package com.neogrowth.catalog.dao;

import java.util.List;

import com.neogrowth.catalog.model.persistence.Movie;

/**
 * Declare the method of {@link MovieDao}
 * @author Ashish
 * @since Aug 14, 2017
 */
public interface MovieDao {
	
	public List<Movie> getAll(int limit);
	public Movie save(Movie movie);
	public List<Movie> search(String value, int limit);
	public List<Movie> getByRating(int limit);
	public long getCount();
}
