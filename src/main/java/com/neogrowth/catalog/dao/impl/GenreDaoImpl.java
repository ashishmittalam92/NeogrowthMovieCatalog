package com.neogrowth.catalog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neogrowth.catalog.dao.GenreDao;
import com.neogrowth.catalog.model.persistence.Genre;
import com.neogrowth.catalog.repository.GenreRepository;

/**
 * Implementation of {@link GenreDao} and define the method 
 * @author Ashish
 * @since Aug 15, 2017
 */
@Repository
public class GenreDaoImpl implements GenreDao {

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public List<Genre> getAll() {
		return (List<Genre>)genreRepository.findAll();
	}

	/**
	 * Find genre by given id
	 * param id
	 * return {@link Genre}
	 */
	@Override
	public Genre getById(int id) {
		return genreRepository.findOne(id);
	}

}
