package com.neogrowth.catalog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neogrowth.catalog.dao.PersonDao;
import com.neogrowth.catalog.model.persistence.Person;
import com.neogrowth.catalog.repository.PersonRepository;

/**
 * This is implementation of {@link PersonDao} and define the method 
 * @author Ashish
 * @since Aug 15, 2017
 */
@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Search person using name
	 * param name
	 * return list of {@link Person}
	 */
	@Override
	public List<Person> search(String name) {
		return personRepository.findByNameContaining(name);
	}

	/**
	 * Get all {@link Person}
	 * return list of {@link Person}
	 */
	@Override
	public List<Person> getAll() {
		return (List<Person>) personRepository.findAll();
	}

	/**
	 * Get {@link Person} object using id
	 * param id
	 * return {@link Person}
	 */
	@Override
	public Person getById(int id) {
		return personRepository.findOne(id);
	}

}
