package com.example.demo.prakash.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

//@Data
@Getter
public class AuthorDTO  {


	private String email;

	@NotNull(message = "FirstName cannot be blank")
	private String firstName;

	@NotNull(message = "LastName cannot be blank")
	private String lastName;

	private String userName;

	private String mobile;

	private String add_line_1;

	private String add_line_2;

}
