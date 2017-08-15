package com.neogrowth.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neogrowth.catalog.dao.GenreDao;
import com.neogrowth.catalog.model.persistence.Genre;
import com.neogrowth.catalog.service.GenreService;

/**
 * Implemented {@link GenreService} and defined its method
 * @author Ashish
 * @since Aug 15, 2017
 */
@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreDao genreDao;

	/**
	 * Get list of {@link Genre}
	 * return list of {@link Genre}
	 */
	@Override
	public List<Genre> getAll() {
		return genreDao.getAll();
	}

	/**
	 * Find {@link Genre} using id
	 * param id
	 * return {@link Genre}
	 */
	@Override
	public Genre getById(int id) {
		return genreDao.getById(id);
	}
	
	
}
