package com.comohogar.benefit.application.dtos.requests;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateClientBenefitRequest extends ClientBaseRequest {

	@NotBlank(message = "Group Type field can't be empty.")
	private String groupType;

	@NotBlank(message = "Benefit field can't be empty.")
	private String benefit;

}
