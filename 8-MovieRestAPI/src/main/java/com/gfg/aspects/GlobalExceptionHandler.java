package com.gfg.aspects;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gfg.dto.MovieError;
import com.gfg.exceptions.MovieException;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(MovieException.class)
	public MovieError handleMovieException(MovieException e)
	{
		return new MovieError(e.getMessage());
	}
}
