package com.example.demo.prakash.service;

import com.example.demo.prakash.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.example.demo.prakash.dto.AuthorDTO;

import java.util.List;

public interface BooksService {

	ResponseEntity<String> createAuthor(AuthorDTO request);

	Object getAuthorDetails(Integer id);

	List<AuthorDTO> getAllAuthorDetails(Integer pageNumber);
}
