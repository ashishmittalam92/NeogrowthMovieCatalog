package com.neogrowth.catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neogrowth.catalog.dao.PersonMovieDao;
import com.neogrowth.catalog.model.persistence.PersonMovie;
import com.neogrowth.catalog.service.PersonMovieService;

/**
 * Implemented {@link PersonMovieService} and defined its method
 * @author Ashish
 * @since Aug 15, 2017
 */
@Service
public class PersonMovieServiceImpl implements PersonMovieService {

	@Autowired
	private PersonMovieDao personMovieDao;
	
	/**
	 * Save {@link PersonMovie} in database
	 * param personMovie
	 * return {@link PersonMovie}
	 */
	@Override
	public PersonMovie save(PersonMovie personMovie) {
		return personMovieDao.save(personMovie);
	}

}
