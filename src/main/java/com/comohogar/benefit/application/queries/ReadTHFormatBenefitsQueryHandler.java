package com.comohogar.benefit.application.queries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comohogar.benefit.domain.entities.THFormat;
import com.comohogar.benefit.domain.interfaces.repositories.ITHFormatRepository;

import io.jkratz.mediator.core.RequestHandler;
import lombok.SneakyThrows;

@Component
public class ReadTHFormatBenefitsQueryHandler implements RequestHandler<ReadTHFormatBenefitsQuery, List<String>> {

	@Autowired
	private ITHFormatRepository formatRepository;

	@Override
	@SneakyThrows
	public List<String> handle(ReadTHFormatBenefitsQuery query) {
		var thFormat = formatRepository.getTHFormat().orElse(new THFormat());
		if (thFormat.getBeneficio() == null) {
			thFormat.setBeneficio(new ArrayList<>());
		}
		return thFormat.getBeneficio();

	}

}
