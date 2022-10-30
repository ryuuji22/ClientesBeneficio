package com.comohogar.benefit.domain.services.validations;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseBenefitValidation implements Command {

	private String benefit;

}
