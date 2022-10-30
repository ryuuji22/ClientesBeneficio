package com.comohogar.benefit.api.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.comohogar.benefit.application.command.create.CreateClientCommand;
import com.comohogar.benefit.application.queries.ReadAllClientsQuery;
import com.comohogar.benefit.domain.entities.Client;

import io.jkratz.mediator.core.Mediator;

/**
 *
 * @author diegohinojosa
 */
@RunWith(SpringRunner.class)
public class ClientControllerTest {

	@InjectMocks
	ClientController controller;

	@Mock
	Mediator mediator;

	@Test
	public void readClients() {
		var client = new Client();
		client.setId("1");
		client.setEmail("test@test.com");
		client.setNames("Test Test");
		client.setEnabled(Boolean.TRUE);
		var listClients = List.of(client);

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Mockito.doReturn(listClients).when(mediator).dispatch(any(ReadAllClientsQuery.class));

		ResponseEntity<List<Client>> responseEntity = controller.readClients();

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(responseEntity.getBody()).isNotEmpty();
	}

	@Test
	public void createClient() {
		CreateClientCommand command = new CreateClientCommand();
		command.setBenefit("Descuento1");
		command.setEmail("ejemplo@gmail.com");
		command.setGroupType("sk");
		command.setNames("Diego");

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Mockito.doNothing().when(mediator).dispatch(any(CreateClientCommand.class));

		ResponseEntity<Void> responseEntity = controller.createClient(command);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);

	}

}
