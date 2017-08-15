package com.neogrowth.catalog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neogrowth.catalog.dao.PersonMovieDao;
import com.neogrowth.catalog.model.persistence.PersonMovie;
import com.neogrowth.catalog.repository.PersonMovieRepository;

/**
 * This is implementation of {@link PersonMovieDao} and define the method 
 * @author Ashish
 * @since Aug 15, 2017
 */
@Repository
public class PersonMovieDaoImpl implements PersonMovieDao {

	@Autowired
	private PersonMovieRepository personMovieRepository;
	
	/**
	 * Save {@link PersonMovie} in database
	 * param {@link PersonMovie}
	 * return {@link PersonMovie}
	 */
	@Override
	public PersonMovie save(PersonMovie personMovie) {
		return personMovieRepository.save(personMovie);
	}

}
