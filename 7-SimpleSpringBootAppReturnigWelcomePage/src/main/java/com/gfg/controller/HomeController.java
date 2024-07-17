package com.gfg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController 
{
	@GetMapping("/welcome") // http://localhost:8080/api/welcome
	public ResponseEntity<?> welcomePage()
	{
		System.out.println("This is welcome Page...!!!");
		return new ResponseEntity<>("This is welcome Page...!!!", HttpStatus.OK);
	}
	
	@GetMapping(value="/welcome2", produces = "text/html") // http://localhost:8080/api/welcome2
	public String Welcomepage2()
	{
		return "<font size=10 color=yellow>This is welcome Page...!!!</font>";
	}
}
