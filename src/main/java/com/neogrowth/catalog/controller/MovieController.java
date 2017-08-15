package com.neogrowth.catalog.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neogrowth.catalog.model.persistence.Genre;
import com.neogrowth.catalog.model.persistence.GenreMovie;
import com.neogrowth.catalog.model.persistence.GenreMoviePK;
import com.neogrowth.catalog.model.persistence.Movie;
import com.neogrowth.catalog.model.persistence.Person;
import com.neogrowth.catalog.model.persistence.PersonMovie;
import com.neogrowth.catalog.model.persistence.PersonMoviePK;
import com.neogrowth.catalog.request.MovieRequest;
import com.neogrowth.catalog.response.MovieDetailResponse;
import com.neogrowth.catalog.response.MovieResponse;
import com.neogrowth.catalog.response.Response;
import com.neogrowth.catalog.service.GenreMovieService;
import com.neogrowth.catalog.service.GenreService;
import com.neogrowth.catalog.service.MovieService;
import com.neogrowth.catalog.service.PersonMovieService;
import com.neogrowth.catalog.service.PersonService;

/**
 * This controller used for movies operation
 * @author Ashish
 * @since Aug 14, 2017
 */
@RequestMapping("/movie")
@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private PersonService personService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private PersonMovieService personMovieService;
	
	@Autowired
	private GenreMovieService genreMovieService;
	
	/**
	 * Return {@link MovieDetailResponse} with Movie information and total page count
	 * @param name
	 * @param limit
	 * @return {@link MovieDetailResponse}
	 */
	@GetMapping("/search/{name}/{limit}")
	public MovieDetailResponse search(@PathVariable("name") String name, @PathVariable("limit") int limit) {
		MovieDetailResponse movieDetailResponse = new MovieDetailResponse();
		List<Movie> movies = movieService.search(name, limit);
		
		List<Person> persons = personService.search(name);
		
		persons.forEach(person -> {
			person.getPersonMovie().forEach(action -> {
				movies.add(action.getMovie());
			});
		});
		
		movieDetailResponse.setMovieResponses(getMovieResponse(movies));
		movieDetailResponse.setTotalPages(movieService.getCount());
		return movieDetailResponse;
	}
	
	/**
	 * Save Movie in database
	 * @param movieRequest
	 * @return {@link Movie}
	 */
	@PostMapping("/")
	public Response save(@RequestBody MovieRequest movieRequest) {
		Movie movie = new Movie();
		movie.setName(movieRequest.getName());
		movie.setImdbRating(movieRequest.getImdbRating());
		movie.setReleaseYear(movieRequest.getReleaseYear());
		
		movie = movieService.save(movie);
		
		Person person = personService.getById(Integer.parseInt(movieRequest.getActor()));
		
		PersonMoviePK personMoviePK = new PersonMoviePK();
		personMoviePK.setMovieId(movie.getId());
		personMoviePK.setPersonId(person.getId());
		
		PersonMovie personMovie = new PersonMovie();
		personMovie.setMovie(movie);
		personMovie.setPerson(person);
		personMovie.setPersonMoviePK(personMoviePK);
		
		personMovie = personMovieService.save(personMovie);
		
		Genre genre = genreService.getById(Integer.parseInt(movieRequest.getGenre()));
		
		GenreMoviePK genreMoviePK = new GenreMoviePK();
		genreMoviePK.setGenreId(genre.getId());
		genreMoviePK.setMovieId(movie.getId());
		
		GenreMovie genreMovie = new GenreMovie();
		genreMovie.setGenre(genre);
		genreMovie.setMovie(movie);
		genreMovie.setGenreMoviePK(genreMoviePK);
		
		genreMovie = genreMovieService.save(genreMovie);
		
		Response response = new Response();
		response.setMessage("Movie is successfully saved.");
		
		return response;
	}
	
	/**
	 * Return Set of Movie based on rating
	 * @param rating
	 * @param limit
	 * @return Set of {@link Movie}
	 */
	/**
	 * Return {@link MovieDetailResponse} sorted by descending with imdb rating
	 * @param limit
	 * @return {@link MovieDetailResponse}
	 */
	@GetMapping("/rating/{limit}")
	public MovieDetailResponse getByRating(@PathVariable("limit") int limit) {
		MovieDetailResponse movieDetailResponse = new MovieDetailResponse();
		List<Movie> movies = movieService.getByRating(limit);
		
		movieDetailResponse.setMovieResponses(getMovieResponse(movies));
		movieDetailResponse.setTotalPages(movieService.getCount());
		return movieDetailResponse;
	}
	
	/**
	 * Get all movies
	 * @param limit
	 * @return {@link MovieDetailResponse}
	 */
	@GetMapping("/page/{limit}")
	public MovieDetailResponse getAll(@PathVariable("limit") int limit) {
		MovieDetailResponse movieDetailResponse = new MovieDetailResponse();
		List<Movie> movies = movieService.getAll(limit);
		
		movieDetailResponse.setMovieResponses(getMovieResponse(movies));
		movieDetailResponse.setTotalPages(movieService.getCount());
		return movieDetailResponse;
	}
	
	/**
	 * Convert list of {@link Movie} object into list of {@link MovieResponse} 
	 * @param movies
	 * @return list of {@link MovieResponse}
	 */
	private List<MovieResponse> getMovieResponse(Collection<Movie> movies) {
		List<MovieResponse> movieResponses = new ArrayList<>(); 
		
		movies.forEach(movie -> {
			MovieResponse movieResponse = new MovieResponse();
			movieResponse.setId(movie.getId());
			movieResponse.setName(movie.getName());
			movieResponse.setImdbRating(movie.getImdbRating());
			movieResponse.setReleaseYear(movie.getReleaseYear());
			
			Set<String> actors = new HashSet<>();
			Set<String> directors = new HashSet<>();
			Set<String> genres = new HashSet<>();
			
			movie.getGenreMovie().forEach(genre -> {
				genres.add(genre.getGenre().getName());
			});
			
			movieResponse.setGenres(genres);
			
			movie.getPersonMovie().forEach(action -> {
				if(action.getPerson().getType().equals("Actor")) {
					actors.add(action.getPerson().getName());
				} else {
					directors.add(action.getPerson().getName());
				}
			});
			
			movieResponse.setActors(actors);
			movieResponse.setDirectors(directors);
			
			movieResponses.add(movieResponse);
		});
		
		return movieResponses;
	}
}
