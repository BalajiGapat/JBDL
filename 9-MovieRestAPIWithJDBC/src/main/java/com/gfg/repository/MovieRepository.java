package com.gfg.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gfg.dbutils.DBUtils;
import com.gfg.entity.Movie;

@Repository
public class MovieRepository 
{
	@Autowired
	private DBUtils db;
	
	public List<Movie> getAllMovies()
	{
		List<Movie> list=new ArrayList<>();
		Connection con=db.getConn();
		String sql="select * from movie";
		try 
		{
			Statement stm=con.createStatement();
			ResultSet rst=stm.executeQuery(sql);
			
			//OR
			// PreparedStatement pst=con.prepareStatement(sql);
			// ResultSet rst=pst.executeQuery();
			
			while(rst.next())
			{
				Movie m=new Movie();
				int mId=rst.getInt(1);
				String mName=rst.getString(2);
				String mGenre=rst.getString(3);
				String mLanguage=rst.getString(4);
				
				m.setMoviId(mId);
				m.setMovieName(mName);
				m.setGenre(mGenre);
				m.setLanguage(mLanguage);
				list.add(m);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Movie addMovie(Movie m)
	{
		Connection con=db.getConn();
		String sql="insert into movie values(?, ?, ?, ?)";
		try 
		{
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1, m.getMoviId());
			pst.setString(2, m.getMovieName());
			pst.setString(3, m.getGenre());
			pst.setString(4, m.getLanguage());
		
			// insert/update/delete queries...
			pst.executeUpdate(); // fire the query in database
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return m;
	}
	
	public Movie findById(int movieId)
	{
		Movie m=new Movie();
		Connection con=db.getConn();
		String sql="select * from movie where movieId=?";
		try 
		{
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, movieId);
			ResultSet rst=pst.executeQuery();
			if(rst.next())
			{
				int mId=rst.getInt(1);
				String mName=rst.getString(2);
				String mGenre=rst.getString(3);
				String mLanguage=rst.getString(4);
				
				m.setMoviId(mId);
				m.setMovieName(mName);
				m.setGenre(mGenre);
				m.setLanguage(mLanguage);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return m;
	}
	
}
