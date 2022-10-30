package com.comohogar.benefit.application.command.create;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comohogar.benefit.domain.entities.Client;
import com.comohogar.benefit.domain.enums.GroupType;
import com.comohogar.benefit.domain.exceptions.ApplicationDomainException;
import com.comohogar.benefit.domain.interfaces.repositories.IClientRepository;
import com.comohogar.benefit.domain.services.validations.BenefitTakenValidationService;
import com.comohogar.benefit.domain.services.validations.BenefitValidationFactory;
import com.comohogar.benefit.domain.services.validations.ClientGroupValidationService;

import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;
import lombok.SneakyThrows;

@Component
public class CreateClientCommandHandler implements CommandHandler<CreateClientCommand> {

	@Autowired
	private IClientRepository clientRepository;
	@Autowired
	private Mediator mediator;

	@Override
	@SneakyThrows
	@Transactional
	public void handle(CreateClientCommand command) {

		GroupType typeEnum = GroupType.valueOf(command.getGroupType().toUpperCase());

		this.applyValidations(command, typeEnum);

		var newClient = new Client();
		newClient.setNames(command.getNames());
		newClient.setEmail(command.getEmail());
		newClient.setPhone(command.getPhone());
		newClient.setType(typeEnum);
		newClient.setOption(command.getBenefit());

		clientRepository.create(newClient);

	}

	private void applyValidations(CreateClientCommand command, GroupType typeEnum) {
		var baseValidatorService = BenefitValidationFactory.getValidator(typeEnum.toString())
				.orElseThrow(() -> new ApplicationDomainException("Invalid Validator"));

		baseValidatorService.setBenefit(command.getBenefit());

		this.mediator.dispatch(baseValidatorService);

		this.mediator.dispatch(new ClientGroupValidationService(command.getNames(), typeEnum));

		this.mediator.dispatch(new BenefitTakenValidationService(typeEnum, command.getBenefit()));

	}

}
