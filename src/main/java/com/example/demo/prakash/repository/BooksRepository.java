package com.example.demo.prakash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.prakash.domain.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{

}
