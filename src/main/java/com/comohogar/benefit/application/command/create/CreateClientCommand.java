package com.comohogar.benefit.application.command.create;

import com.comohogar.benefit.application.dtos.requests.CreateClientBenefitRequest;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateClientCommand extends CreateClientBenefitRequest implements Command {


}
