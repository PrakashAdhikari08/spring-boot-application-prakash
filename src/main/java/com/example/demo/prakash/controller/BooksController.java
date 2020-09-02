package com.example.demo.prakash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.prakash.dto.AuthorDTO;
import com.example.demo.prakash.service.BooksService;

import javax.validation.Valid;

@RestController
@RequestMapping("/books/v1/")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@PostMapping("/createAuthor")
	public ResponseEntity<String> createAuthor(@RequestBody @Valid AuthorDTO request) {

		return booksService.createAuthor(request);

	}

	@GetMapping("/getAuthor/{id}")
	public Object getAuthorDetails(@PathVariable Integer id){
		return booksService.getAuthorDetails(id);
	}
}



