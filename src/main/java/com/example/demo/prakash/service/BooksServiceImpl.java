package com.example.demo.prakash.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.prakash.domain.Author;
import com.example.demo.prakash.domain.Contact;
import com.example.demo.prakash.dto.AuthorDTO;
import com.example.demo.prakash.exceptions.DuplicateEmailException;
import com.example.demo.prakash.repository.AuthorRepository;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public ResponseEntity<String> createAuthor(AuthorDTO authorDTO) {

		try {
			Author a = authorRepository.findByEmail(authorDTO.getEmail());

			if (a != null)
				throw new DuplicateEmailException("Duplicate email");

			Author author = new Author();

			author.setEmail(authorDTO.getEmail());
			author.setFirstName(authorDTO.getFirstName());
			author.setLastName(authorDTO.getLastName());
			author.setUserName(authorDTO.getUserName());

			Contact contact = new Contact();
			contact.setAddress_line_1(authorDTO.getAdd_line_1());
			contact.setAddress_line_2(authorDTO.getAdd_line_2());
			contact.setMobileNumber(authorDTO.getMobile());

			author.setContact(contact);

			authorRepository.save(author);
			return new ResponseEntity<String>("author created", HttpStatus.CREATED);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object getAuthorDetails(Integer id) {

		Optional<Author> author = authorRepository.findById(id);
		author.orElseThrow(()-> new RuntimeException("Author not found"));

		Author author1 = author.get();
		return author1;
	}
}






//DTO->DATA TRANSFER OBJECT
