package com.comohogar.benefit.domain.services.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comohogar.benefit.domain.enums.GroupType;
import com.comohogar.benefit.domain.exceptions.ApplicationDomainException;
import com.comohogar.benefit.domain.interfaces.repositories.IClientRepository;

import io.jkratz.mediator.core.CommandHandler;
import lombok.SneakyThrows;

@Component
public class ClientGroupValidationServiceHandler implements CommandHandler<ClientGroupValidationService> {

	@Autowired
	private IClientRepository clientRepository;

	@Override
	@SneakyThrows
	public void handle(ClientGroupValidationService service) {
		this.validateClientByNameAndType(service.getClientName(), service.getGroupType());
	}

	private void validateClientByNameAndType(String name, GroupType type) {
		var foundClient = clientRepository.findByNamesAndType(name, type);
		if (foundClient.isPresent()) {
			throw new ApplicationDomainException("Client is already registered for benefit in " + type + " list");
		}
	}

}
