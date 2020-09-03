package com.example.demo.prakash.controller;

import com.example.demo.prakash.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.prakash.dto.AuthorDTO;
import com.example.demo.prakash.service.BooksService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books/v1/")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@PostMapping("/createAuthor")
	public ResponseEntity<String> createAuthor(@RequestBody @Valid AuthorDTO request) {

		return booksService.createAuthor(request);

	}

	@GetMapping("/getAuthors")
	public Object getAuthorDetails(@RequestParam(required = false) Integer id){
		return booksService.getAuthorDetails(id);
	}

	@GetMapping("/getAllAuthorsDetails/{pageNumber}")
	public List<AuthorDTO> getAllAuthorDetails(@PathVariable Integer pageNumber){
		return booksService.getAllAuthorDetails(pageNumber);
	}


}



