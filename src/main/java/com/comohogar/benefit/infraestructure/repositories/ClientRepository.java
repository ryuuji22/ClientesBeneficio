/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comohogar.benefit.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comohogar.benefit.domain.entities.Client;
import com.comohogar.benefit.domain.enums.GroupType;
import com.comohogar.benefit.domain.interfaces.repositories.IClientRepository;
import com.comohogar.benefit.infraestructure.persistance.mappers.ClientMapper;
import com.comohogar.benefit.infraestructure.repositories.jpa.IJpaClientRepository;

/**
 *
 * @author diego
 */
@Repository
public class ClientRepository implements IClientRepository {

	@Autowired
	private IJpaClientRepository jpaClientRepository;

	@Autowired
	private ClientMapper mapper;

	@Override
	public Optional<List<Client>> getAll() {
		return jpaClientRepository.findByEnabled(Boolean.TRUE).map(mapper::toClients);
	}

	@Override
	public String create(Client client) {
		var clientModel = mapper.toClientModel(client);
		return jpaClientRepository.save(clientModel).getId();
	}

	@Override
	public Optional<Client> findByNamesAndType(String names, GroupType type) {
		return this.jpaClientRepository.findByNamesAndTypeAndEnabled(names, type, Boolean.TRUE)
				.map(mapper::toClient);
	}

	@Override
	public Optional<Client> findByTypeAndOption(GroupType type, String option) {
		return this.jpaClientRepository.findByTypeAndOptionAndEnabled(type, option, Boolean.TRUE)
				.map(mapper::toClient);
	}

}
