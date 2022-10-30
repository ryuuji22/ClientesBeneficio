package com.comohogar.benefit.application.command.create;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.test.context.junit4.SpringRunner;

import com.comohogar.benefit.domain.entities.Client;
import com.comohogar.benefit.domain.enums.GroupType;
import com.comohogar.benefit.domain.interfaces.repositories.IClientRepository;
import com.comohogar.benefit.domain.services.validations.BaseBenefitValidation;
import com.comohogar.benefit.domain.services.validations.BenefitTakenValidationService;
import com.comohogar.benefit.domain.services.validations.ClientGroupValidationService;

import io.jkratz.mediator.core.Mediator;

@RunWith(SpringRunner.class)
public class CreateClientCommandHandlerTest {

	@InjectMocks
	private CreateClientCommandHandler commandHandler;

	@Mock
	private IClientRepository clientRepository;

	@Mock
	private Mediator mediator;

	private Client client;

	@Before
	public void setUp() throws ParseException {
		client = new Client();
		client.setNames("Diego");
		client.setEmail("ejemplo@gmail.com");
		client.setType(GroupType.SK);
		client.setOption("Descuento1");

		Mockito.doNothing().when(mediator).dispatch(any(BaseBenefitValidation.class));
		Mockito.doNothing().when(mediator).dispatch(any(ClientGroupValidationService.class));
		Mockito.doNothing().when(mediator).dispatch(any(BenefitTakenValidationService.class));
		Mockito.doReturn("1").when(clientRepository).create(any(Client.class));

	}

	@Test
	public void validateNotNullMocks() {
		assertThat(clientRepository).isNotNull();
		assertThat(mediator).isNotNull();
		assertThat(commandHandler).isNotNull();

	}

	@Test
	public void shoudCreateClient() {
		CreateClientCommand command = new CreateClientCommand();
		command.setBenefit("Descuento1");
		command.setEmail("ejemplo@gmail.com");
		command.setGroupType("sk");
		command.setNames("Diego");
		commandHandler.handle(command);

		this.verifyCreateClientIsCalledOnce();

	}

	@Test
	public void shoudCreateClient_ILLEGAL_GROUP_TYPE() {
		CreateClientCommand command = new CreateClientCommand();
		command.setBenefit("Descuento1");
		command.setEmail("ejemplo@gmail.com");
		command.setGroupType("NA");
		command.setNames("Diego");

		Assert.assertThrows(IllegalArgumentException.class, () -> commandHandler.handle(command));
	}

	private void verifyCreateClientIsCalledOnce() {
		Mockito.verify(clientRepository, VerificationModeFactory.times(1)).create(any(Client.class));
		Mockito.reset(clientRepository);
	}

}
