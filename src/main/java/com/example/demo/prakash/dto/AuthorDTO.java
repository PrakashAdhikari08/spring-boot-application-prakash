package com.example.demo.prakash.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Data
public class AuthorDTO  {


	private String email;

	@NotNull(message = "FirstName cannot be blank")
	private String firstName;

	@NotNull(message = "LastName cannot be blank")
	private String lastName;

	private String userName;

	private ContactDTO contactDTO;

}
