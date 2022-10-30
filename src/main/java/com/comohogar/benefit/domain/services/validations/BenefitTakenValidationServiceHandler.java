package com.comohogar.benefit.domain.services.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comohogar.benefit.domain.enums.GroupType;
import com.comohogar.benefit.domain.exceptions.ApplicationDomainException;
import com.comohogar.benefit.domain.interfaces.repositories.IClientRepository;

import io.jkratz.mediator.core.CommandHandler;
import lombok.SneakyThrows;

@Component
public class BenefitTakenValidationServiceHandler implements CommandHandler<BenefitTakenValidationService> {

	@Autowired
	private IClientRepository clientRepository;

	@Override
	@SneakyThrows
	public void handle(BenefitTakenValidationService service) {
		this.validateBenefitTakenByTypeAndOption(service.getGroupType(), service.getBenefit());
	}

	private void validateBenefitTakenByTypeAndOption(GroupType type, String option) {
		var foundClient = clientRepository.findByTypeAndOption(type, option);
		if (foundClient.isPresent()) {
			throw new ApplicationDomainException("Benefit " + option + " is already taken");
		}
	}

}
