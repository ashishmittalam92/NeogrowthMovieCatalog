package com.neogrowth.catalog.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.neogrowth.catalog.model.persistence.Movie;

/**
 *  This repository is used for performing event for {@link Movie}
 * @author Ashish
 * @since Aug 14, 2017
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie, Serializable>, PagingAndSortingRepository<Movie, Serializable> {
	
	@Query("select m from Movie m where m.name like %?1%")
	public List<Movie> findByNameContaining(String name, Pageable pageable);	
}
