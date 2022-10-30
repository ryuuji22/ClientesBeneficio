package com.comohogar.benefit.application.dtos.requests;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientBaseRequest {

	@NotBlank(message = "Names field can't be empty.")
	private String names;

	@Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")
	@Email(message = "You must provide a valid email format")
	@NotBlank(message = "Email field can't be empty.")
	private String email;

	@Digits(message = "Phone Number Only digits allowed", fraction = 0, integer = 12)
	private String phone;
	
	

}
