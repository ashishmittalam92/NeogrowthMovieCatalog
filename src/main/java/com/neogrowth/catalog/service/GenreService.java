package com.neogrowth.catalog.service;

import java.util.List;

import com.neogrowth.catalog.model.persistence.Genre;

/**
 * Declare service method of {@link Genre}
 * @author Ashish
 * @since Aug 15, 2017
 */
public interface GenreService {

	public List<Genre> getAll();
	public Genre getById(int id);
}
