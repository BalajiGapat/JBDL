package com.gfg.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gfg.entity.Movie;

@Repository
public class MovieRepository 
{
	private static  List<Movie> list=new ArrayList<>();
	
	static 
	{
		list.add(new Movie(101, "Matrix", "SCIFI", "ENG"));
		list.add(new Movie(102, "MI", "ACTION", "ENG"));
		list.add(new Movie(103, "Terminator", "SCIFI", "ENG"));
		list.add(new Movie(104, "Speed", "ACTION", "ENG"));
		list.add(new Movie(105, "Fast and Furious", "ACTION", "ENG"));
	}
	
	public List<Movie> getAllMovies()
	{
		return list;
	}
	
}
