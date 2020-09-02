package com.example.demo.prakash.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "author_tbl")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "email_id", unique = true)
	private String email;

	private String firstName;

	private String lastName;

	private String userName;

	@Embedded
	private Contact contact;
//
//	@OneToMany(mappedBy = "author")
//	List<Books> books;
}
