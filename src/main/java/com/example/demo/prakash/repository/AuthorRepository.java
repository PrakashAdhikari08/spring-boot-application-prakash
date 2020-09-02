package com.example.demo.prakash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.prakash.domain.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

	Author findByEmail(String string);

    Optional<Author> findById(Integer id);
}
