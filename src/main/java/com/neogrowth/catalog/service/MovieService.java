package com.neogrowth.catalog.service;

import java.util.List;

import com.neogrowth.catalog.model.persistence.Movie;

/**
 * Declare service method of {@link Movie}
 * @author Ashish
 * @since Aug 15, 2017
 */
public interface MovieService {

	public List<Movie> getAll(int limit);
	public Movie save(Movie movie);
	public List<Movie> search(String name, int limit);
	public List<Movie> getByRating(int limit);
	public long getCount();
}
