package com.gfg.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie 
{
	private int moviId;
	private String movieName;
	private String genre;
	private String language;
	
	public Movie() 
	{
		
	}

	public Movie(int moviId, String movieName, String genre, String language) 
	{
		super();
		this.moviId = moviId;
		this.movieName = movieName;
		this.genre = genre;
		this.language = language;
	}

	public int getMoviId() {
		return moviId;
	}

	public void setMoviId(int moviId) {
		this.moviId = moviId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString()
	{
		return "Movie [moviId=" + moviId + ", movieName=" + movieName + ", genre=" + genre + ", language=" + language
				+ "]";
	}
	
}
