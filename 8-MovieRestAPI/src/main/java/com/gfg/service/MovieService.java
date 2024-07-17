package com.gfg.service;

import java.util.List;

import com.gfg.entity.Movie;

public interface MovieService 
{
	List<Movie> allMovies();
	
	Movie searchById(int movieId);
	
	void deleteById(int movieid);
	
	List<Movie> addNewMovie(Movie m);
	
	Movie updateMovie(Movie movie, int movieId);

	List<Movie> findByGenre(String genre);
}
