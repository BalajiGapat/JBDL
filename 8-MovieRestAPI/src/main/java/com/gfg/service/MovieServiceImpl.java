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
		List<Movie> list=movieRepository.getAllMovies();
		
		Movie movie=list.stream()
						.filter(m->m.getMoviId()==movieId)
						.findFirst()
						// .get();
						.orElseThrow( ()-> new MovieException("The movieid: "+movieId+" not found...!!!"));
		return movie;
	}

	@Override
	public void deleteById(int movieid) 
	{
		List<Movie> list=movieRepository.getAllMovies();
		
		list.removeIf(m->m.getMoviId()==movieid);
	}

	@Override
	public List<Movie> addNewMovie(Movie m) 
	{
		List<Movie> list=movieRepository.getAllMovies();
		list.add(m);
		return list;	 
	}
	
	public Movie updateMovie(Movie movie, int movieId)
	{
		List<Movie> list= movieRepository.getAllMovies();
		
		List<Movie> filterList=list.stream()
									.filter(m->m.getMoviId()==movieId)
									.collect(Collectors.toList());
		
		if(filterList.isEmpty())
			throw new MovieException("The movieid: "+movieId+" not found...!!!");
		
		Movie updateMovie=filterList.get(0);
		updateMovie.setMovieName(movie.getMovieName());
		updateMovie.setGenre(movie.getGenre());
		updateMovie.setLanguage(movie.getLanguage());
		
		return updateMovie;
	}

	@Override
	public List<Movie> findByGenre(String genre) 
	{
		List<Movie> list=movieRepository.getAllMovies();
		List<Movie> genreList=list.stream()
			.filter(m->m.getGenre().equals(genre))
			.toList();
		return genreList;
	}
	
	

}
