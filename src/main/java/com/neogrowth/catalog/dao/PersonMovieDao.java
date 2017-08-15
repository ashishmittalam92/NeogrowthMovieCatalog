package com.neogrowth.catalog.dao;

import com.neogrowth.catalog.model.persistence.PersonMovie;

/**
 * Declare method of {@link PersonMovieDao} 
 * @author Ashish
 * @since Aug 15, 2017
 */
public interface PersonMovieDao {

	public PersonMovie save(PersonMovie personMovie);
}
