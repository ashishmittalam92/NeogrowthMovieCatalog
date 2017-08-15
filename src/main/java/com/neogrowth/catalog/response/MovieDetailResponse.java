package com.neogrowth.catalog.response;

import java.util.List;

public class MovieDetailResponse {

	private long totalPages;
	private List<MovieResponse> movieResponses;
	
	public long getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	
	public List<MovieResponse> getMovieResponses() {
		return movieResponses;
	}
	
	public void setMovieResponses(List<MovieResponse> movieResponses) {
		this.movieResponses = movieResponses;
	}
}
