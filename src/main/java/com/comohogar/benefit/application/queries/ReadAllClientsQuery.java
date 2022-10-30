package com.comohogar.benefit.application.queries;

import java.util.List;

import com.comohogar.benefit.domain.entities.Client;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReadAllClientsQuery implements Request<List<Client>> {


}
