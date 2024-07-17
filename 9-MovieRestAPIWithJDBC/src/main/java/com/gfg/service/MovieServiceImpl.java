package com.gfg.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfg.entity.Movie;
import com.gfg.exceptions.MovieException;
import com.gfg.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService 
{
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> allMovies() 
	{
		return movieRepository.getAllMovies();
	}

	@Override
	public Movie searchById(int movieId)
	{
		return movieRepository.findById(movieId);
	}

	@Override
	public Movie addNewMovie(Movie m) 
	{
		return movieRepository.addMovie(m);	 
	}
	
}
