package com.neogrowth.catalog.model.persistence;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * JPA model of PersonMovie table
 * @author Ashish
 * @since Aug 14, 2017
 */
@Entity
@Table(name="person_movie")
public class PersonMovie {

	@EmbeddedId
	private PersonMoviePK personMoviePK;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @MapsId("movieId")
    @JoinColumn(name = "movie")
    @JsonBackReference
    private Movie movie;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("personId")
    @JoinColumn(name = "person")
    @JsonBackReference
    private Person person;

	public PersonMoviePK getPersonMoviePK() {
		return personMoviePK;
	}

	public void setPersonMoviePK(PersonMoviePK personMoviePK) {
		this.personMoviePK = personMoviePK;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
