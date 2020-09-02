package com.example.demo.prakash.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.prakash.dto.AuthorDTO;

public interface BooksService {

	ResponseEntity<String> createAuthor(AuthorDTO request);

	Object getAuthorDetails(Integer id);
}
