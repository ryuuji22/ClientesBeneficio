package com.comohogar.benefit.domain.services.validations;

import com.comohogar.benefit.domain.enums.GroupType;

import io.jkratz.mediator.core.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientGroupValidationService implements Command {

	private String clientName;
	private GroupType groupType;

}
