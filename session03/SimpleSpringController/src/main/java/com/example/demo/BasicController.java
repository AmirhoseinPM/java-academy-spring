package com.example.demo;

import java.awt.PageAttributes.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class BasicController {
	
	
	public BasicController() {
		super();
	}
	
	@GetMapping(value = "/books")
	public String books() {
		return "books list";
	}
	
	@PostMapping(value = "/books")
	public String add() {
		return "POST book";
	}
	
	@GetMapping(value = "/books/{id}")
	public String get(@PathVariable final long id) {
		return "get book: " + id;
	}
	
	@PutMapping(value = "/books/{id}")
	public String put(@PathVariable final long id) {
		return "update book: " + id;
	}
	
	@DeleteMapping(value= "books/{id}")
	public String deleteBook(@PathVariable final long id) {
		return "delete book: " + id;
	}
	
}
