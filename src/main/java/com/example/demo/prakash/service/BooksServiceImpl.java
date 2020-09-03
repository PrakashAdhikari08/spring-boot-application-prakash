package com.example.demo.prakash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.prakash.dto.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
			contact.setAddress_line_1(authorDTO.getContactDTO().getAdd_line_1());
			contact.setAddress_line_2(authorDTO.getContactDTO().getAdd_line_2());
			contact.setMobileNumber(authorDTO.getContactDTO().getMobile());

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
		if(id == null){
			List<Author> authors = authorRepository.findAll();

			List<AuthorDTO> authorDTOS = new ArrayList<>();

			//iterating and adding them using for each loop

			authors.forEach(author ->
			{
				AuthorDTO a = new AuthorDTO();
				ContactDTO c = new ContactDTO();

				a.setFirstName(author.getFirstName());
				a.setLastName(author.getLastName());
				a.setEmail(author.getEmail());
				a.setUserName(author.getUserName());

				c.setAdd_line_1(author.getContact().getAddress_line_1());
				c.setAdd_line_1(author.getContact().getAddress_line_2());
				c.setMobile(author.getContact().getMobileNumber());

				a.setContactDTO(c);

				authorDTOS.add(a);
			});
			return authorDTOS;

		}

		Optional<Author> author = authorRepository.findById(id);

		author.orElseThrow(()-> new RuntimeException("Author not found"));

		Author author1 = author.get();
		return author1;
	}

	@Override
	public List<AuthorDTO> getAllAuthorDetails(Integer pageNumber) {

		PageRequest pageRequest = new PageRequest(pageNumber-1,2);

		Page<Author> authors = authorRepository.findAllByOrderByIdDesc(pageRequest);

		//List<Author> authors = authorRepository.findAllByOrderById();
 		List<AuthorDTO> authorDTOS = new ArrayList<>();

		authors.forEach(author ->
		{
			AuthorDTO authorDTO = new AuthorDTO();
			ContactDTO contactDTO = new ContactDTO();
			authorDTO.setEmail(author.getEmail());
			authorDTO.setFirstName(author.getFirstName());
			authorDTO.setLastName(author.getLastName());
			authorDTO.setUserName(author.getUserName());

			contactDTO.setMobile(author.getContact().getMobileNumber());
			contactDTO.setAdd_line_1(author.getContact().getAddress_line_1());
			contactDTO.setAdd_line_2(author.getContact().getAddress_line_2());

			authorDTO.setContactDTO(contactDTO);

			authorDTOS.add(authorDTO);

		});


		return authorDTOS;
	}
}






//DTO->DATA TRANSFER OBJECT
