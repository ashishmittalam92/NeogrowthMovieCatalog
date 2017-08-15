package com.neogrowth.catalog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.neogrowth.catalog.model.persistence.Person;
import com.neogrowth.catalog.response.PersonResponse;
import com.neogrowth.catalog.service.GenreService;
import com.neogrowth.catalog.service.PersonService;

/**
 * This controller is used for UI pages
 * @author Ashish
 * @since Aug 14, 2017
 */
@Controller
public class UIController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private GenreService genreService;
	
	/**
	 * Used for initial page
	 * @return {@link String}
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/**
	 * Used for add page
	 * @param model
	 * @return {@link String}
	 */
	@GetMapping("/add")
	public String add(Model model) {
		List<Person> persons = personService.getAll();
		
		List<PersonResponse> actors = new ArrayList<>();
		List<PersonResponse> directors = new ArrayList<>();
		
		persons.forEach(person -> {
			if(person.getType().equalsIgnoreCase("Actor")) {
				actors.add(new PersonResponse(person.getId(), person.getName()));
			} else {
				directors.add(new PersonResponse(person.getId(), person.getName()));
			}
		});
		
		model.addAttribute("actors", actors);
		model.addAttribute("directors", directors);
		model.addAttribute("genres", genreService.getAll());
		
		List<Integer> years = new ArrayList<>();
		
		for(int year = 1986; year <= 2017; year++) {
			years.add(0, year);
		}
		
		model.addAttribute("years", years);
		
		return "add";
	}
}
