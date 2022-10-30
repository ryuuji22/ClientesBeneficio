package com.comohogar.benefit.domain.services.validations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comohogar.benefit.application.queries.ReadTHFormatBenefitsQuery;
import com.comohogar.benefit.domain.enums.GroupType;
import com.comohogar.benefit.domain.exceptions.ApplicationDomainException;

import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;
import lombok.SneakyThrows;

@Component
public class THBenefitExistsValidationServiceHandler implements CommandHandler<THBenefitExistsValidationService> {

	@Autowired
	private Mediator mediator;

	@Override
	@SneakyThrows
	public void handle(THBenefitExistsValidationService service) {
		this.validateTHBenefitExists(service.getBenefit());
	}

	private void validateTHBenefitExists(String option) {
		var benefits = this.mediator.dispatch(new ReadTHFormatBenefitsQuery());
		List<String> benefitsFound = benefits.stream().filter(x -> x.equals(option)).toList();
		if (benefitsFound.isEmpty()) {
			throw new ApplicationDomainException("Benefit " + option + " doesn´t exist on list " + GroupType.TH);
		}
	}

}
