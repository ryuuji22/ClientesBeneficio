package com.comohogar.benefit.domain.services.validations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comohogar.benefit.application.queries.ReadSKFormatBenefitsQuery;
import com.comohogar.benefit.domain.entities.Benefit;
import com.comohogar.benefit.domain.enums.GroupType;
import com.comohogar.benefit.domain.exceptions.ApplicationDomainException;

import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;
import lombok.SneakyThrows;

@Component
public class SKBenefitExistsValidationServiceHandler implements CommandHandler<SKBenefitExistsValidationService> {

	@Autowired
	private Mediator mediator;

	@Override
	@SneakyThrows
	public void handle(SKBenefitExistsValidationService service) {
		this.validateSKBenefitExists(service.getBenefit());
	}

	private void validateSKBenefitExists(String option) {
		var benefits = this.mediator.dispatch(new ReadSKFormatBenefitsQuery());
		List<Benefit> benefitsFound = benefits.stream().filter(x -> x.getBeneficio().equals(option)).toList();
		if (benefitsFound.isEmpty()) {
			throw new ApplicationDomainException("Benefit " + option + " doesn´t exist on list " + GroupType.SK);
		}
	}

}
