package com.gfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gfg.entity.Movie;
import com.gfg.exceptions.MovieException;
import com.gfg.service.MovieService;

@RestController // This indicates that this class is a REST API Class
@RequestMapping("/api/movies")
public class MovieAPI 
{
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value="/welcome", produces = "text/html") // http://localhost:8080/api/movies/welcome
	public String Welcome()
	{
		return "<font size=10 color=blue>Welcome to Movie API...!!!</font>";
	}
	
	@GetMapping("/sample") // http://localhost:8080/api/movies/sample
	public Movie sampleData()
	{
		return new Movie(123, "Matrix", "SCIENCE", "English");
	}
	
	@GetMapping() // http://localhost:8080/api/movies
	public ResponseEntity<?>/*List<Movie>*/ allMovies()
	{
		List<Movie> list=movieService.allMovies();
		if(list.isEmpty())
		{
			System.out.println("list is empty...!!!");
			throw new MovieException("This list is empty...!!!");
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		//return list;
		return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{movieId}") // http://localhost:8080/api/movies/101
	public Movie searchById(@PathVariable int movieId)
	{
		return movieService.searchById(movieId);
	}
	
	@DeleteMapping("/{movieId}") // http://localhost:8080/api/movies/101
	public ResponseEntity<Void> removeMovie(@PathVariable int movieId)
	{
		movieService.deleteById(movieId);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{movieId}") // http://localhost:8080/api/movies/101
	public Movie updateMovie(@RequestBody  Movie movie, @PathVariable int movieId)
	{
		return movieService.updateMovie(movie, movieId);
	}
	
	@PostMapping(consumes ={"application/xml", "application/json"}, produces ="application/json") // http://localhost:8080/api/movies
	public List<Movie> createMovie(@RequestBody Movie movie)
	{
		return movieService.addNewMovie(movie);	
	}
	
	@GetMapping("/search/genre") // http://localhost:8080/api/movies/search/genre?genre=ACTION
	public List<Movie> searchByGenre(@RequestParam String genre)
	{
		return movieService.findByGenre(genre);
	}
	
}
