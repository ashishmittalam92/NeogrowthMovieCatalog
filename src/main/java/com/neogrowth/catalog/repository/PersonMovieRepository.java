package com.neogrowth.catalog.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neogrowth.catalog.model.persistence.PersonMovie;

/**
 *  This repository is used for performing event for {@link PersonMovie}
 * @author Ashish
 * @since Aug 15, 2017
 */
@Repository
public interface PersonMovieRepository extends CrudRepository<PersonMovie, Serializable> {

}
