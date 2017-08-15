package com.neogrowth.catalog.dao;

import java.util.List;

import com.neogrowth.catalog.model.persistence.Person;

/**
 * Declare all method of {@link PersonDao} 
 * @author Ashish
 * @since Aug 15, 2017
 */
public interface PersonDao {

	public List<Person> search(String name);
	
	public List<Person> getAll();
	
	public Person getById(int id);
}
