package com.neogrowth.catalog.dao;

import java.util.List;

import com.neogrowth.catalog.model.persistence.Genre;

/**
 * Declare all method of {@link GenreDao} 
 * @author Ashish
 * @since Aug 15, 2017
 */
public interface GenreDao {

	public List<Genre> getAll();
	public Genre getById(int id);
}
