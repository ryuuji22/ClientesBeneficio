package com.comohogar.benefit.domain.services.validations;

import com.comohogar.benefit.domain.enums.GroupType;

import io.jkratz.mediator.core.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BenefitTakenValidationService implements Command {

	private GroupType groupType;
	private String benefit;

}
