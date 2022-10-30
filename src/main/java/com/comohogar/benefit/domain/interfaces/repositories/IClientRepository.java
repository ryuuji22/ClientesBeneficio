package com.comohogar.benefit.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;

import com.comohogar.benefit.domain.entities.Client;
import com.comohogar.benefit.domain.enums.GroupType;

public interface IClientRepository {

	Optional<List<Client>> getAll();

	String create(Client client);

	Optional<Client> findByNamesAndType(String names, GroupType type);
	
	Optional<Client> findByTypeAndOption(GroupType type, String option);

}
