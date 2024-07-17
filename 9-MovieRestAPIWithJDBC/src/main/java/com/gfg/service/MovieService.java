package com.gfg.service;

import java.util.List;

import com.gfg.entity.Movie;

public interface MovieService 
{
	List<Movie> allMovies();
	
	Movie searchById(int movieId);
	
	Movie addNewMovie(Movie m);

}
