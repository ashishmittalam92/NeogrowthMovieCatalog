package com.neogrowth.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neogrowth.catalog.dao.PersonDao;
import com.neogrowth.catalog.model.persistence.Person;
import com.neogrowth.catalog.service.PersonService;

/**
 * Implemented {@link PersonService} and defined its method
 * @author Ashish
 * @since Aug 14, 2017
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	/**
	 * Search list of {@link Person} using partial name
	 * param name
	 * return list of {@link Person}
	 */
	@Override
	public List<Person> search(String name) {
		return personDao.search(name);
	}

	/**
	 * Get list of {@link Person}
	 * return list of {@link Person}
	 */
	@Override
	public List<Person> getAll() {
		return personDao.getAll();
	}

	/**
	 * Get {@link Person} using id
	 * param id
	 * return {@link Person}
	 */
	@Override
	public Person getById(int id) {
		return personDao.getById(id);
	}

}
