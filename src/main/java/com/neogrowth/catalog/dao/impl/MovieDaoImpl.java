package com.neogrowth.catalog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.neogrowth.catalog.dao.MovieDao;
import com.neogrowth.catalog.model.persistence.Movie;
import com.neogrowth.catalog.repository.MovieRepository;

/**
 * This is implementation of {@link MovieDao} and define the method 
 * @author Ashish
 * @since Aug 14, 2017
 */
@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private MovieRepository movieRepository;
	
	private int pageNumber = 10;
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Save the {@link Movie} in database
	 * param movie
	 * return {@link Movie}
	 */
	@Override
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	/**
	 * Search movie using partial name and return list of movie with the given limit and page number
	 * param name
	 * param limit
	 * return list of {@link Movie}
	 */
	@Override
	public List<Movie> search(String name, int limit) {
		int startPageNumber = (limit-1);
		PageRequest pageRequest = new PageRequest(startPageNumber, pageNumber, Sort.Direction.ASC, "name");
		return movieRepository.findByNameContaining(name, pageRequest);
	}

	/**
	 * Get all records sorted based on imdb rating in descending order
	 * param limit
	 * return list of {@link Movie}
	 */
	@Override
	public List<Movie> getByRating(int limit) {
		int pageNumber = 10;
		int startPageNumber = (limit-1);
		PageRequest pageRequest = new PageRequest(startPageNumber, pageNumber, Sort.Direction.DESC, "imdbRating");
		return movieRepository.findAll(pageRequest).getContent();
	}

	/**
	 * Get all movie with the given limit and page number
	 * param limit
	 * return list of {@link Movie}
	 */
	@Override
	public List<Movie> getAll(int limit) {
		int startPageNumber = (limit-1);
		PageRequest pageRequest = new PageRequest(startPageNumber, pageNumber, Sort.Direction.ASC, "name");
		return movieRepository.findAll(pageRequest).getContent();
	}

	/**
	 * Count records from Movie table and return number of pages
	 * return long
	 */
	@Override
	public long getCount() {
        Query query = em.createQuery("SELECT count(*) FROM Movie");
        
        return 1 + (((long)query.getSingleResult()) / pageNumber);
	}
}
