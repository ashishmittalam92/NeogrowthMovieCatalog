package com.neogrowth.catalog.service;

import java.util.List;

import com.neogrowth.catalog.model.persistence.Person;

/**
 * Declare service method of {@link Person}
 * @author Ashish
 * @since Aug 15, 2017
 */
public interface PersonService {

	public List<Person> search(String name);	
	public List<Person> getAll();
	public Person getById(int id);
}
