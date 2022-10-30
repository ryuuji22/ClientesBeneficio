package com.comohogar.benefit.infraestructure.persistance.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.comohogar.benefit.domain.entities.Client;
import com.comohogar.benefit.infraestructure.models.ClientModel;

@Mapper(componentModel = "spring")
public interface ClientMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "names", target = "names")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "phone", target = "phone")
	@Mapping(source = "type", target = "type")
	@Mapping(source = "option", target = "option")
	@Mapping(source = "enabled", target = "enabled")
	@Mapping(source = "createdAt", target = "createdAt")
	Client toClient(ClientModel clientModel);

	List<Client> toClients(List<ClientModel> clients);

	@InheritInverseConfiguration
	ClientModel toClientModel(Client client);
}
