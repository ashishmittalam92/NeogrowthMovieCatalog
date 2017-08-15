package com.neogrowth.catalog.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neogrowth.catalog.model.persistence.Person;

/**
 *  This repository is used for performing event for {@link Person}
 * @author Ashish
 * @since Aug 15, 2017
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Serializable> {

	@Query("select p from Person p where p.name like %?1%")
	public List<Person> findByNameContaining(String name);
}
