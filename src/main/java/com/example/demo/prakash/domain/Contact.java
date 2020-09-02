package com.example.demo.prakash.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Contact {

	private String mobileNumber;

	private String address_line_1;

	private String address_line_2;
}
