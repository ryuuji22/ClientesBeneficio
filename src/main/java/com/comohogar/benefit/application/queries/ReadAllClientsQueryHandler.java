package com.comohogar.benefit.application.queries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comohogar.benefit.domain.entities.Client;
import com.comohogar.benefit.domain.interfaces.repositories.IClientRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class ReadAllClientsQueryHandler
		implements RequestHandler<ReadAllClientsQuery, List<Client>> {

	@Autowired
	private IClientRepository clientRepository;

	@Override
	public List<Client> handle(ReadAllClientsQuery query) {
		return clientRepository.getAll()
				.orElse(new ArrayList<>());
	}

}
