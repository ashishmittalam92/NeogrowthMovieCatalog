package com.neogrowth.catalog.model.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * JPA model of Person table
 * @author Ashish
 * @since Aug 14, 2017
 */
@Entity
@Table(name="person")
public class Person implements Serializable {

	private static final long serialVersionUID = 4488613204509694209L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@OneToMany(mappedBy = "person")
    @JsonManagedReference
	private Set<PersonMovie> personMovie;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<PersonMovie> getPersonMovie() {
		return personMovie;
	}

	public void setPersonMovie(Set<PersonMovie> personMovie) {
		this.personMovie = personMovie;
	}
}
