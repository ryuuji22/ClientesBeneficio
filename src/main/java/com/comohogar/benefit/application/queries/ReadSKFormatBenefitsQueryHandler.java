package com.comohogar.benefit.application.queries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comohogar.benefit.domain.entities.Benefit;
import com.comohogar.benefit.domain.entities.SKFormat;
import com.comohogar.benefit.domain.interfaces.repositories.ISKFormatRepository;

import io.jkratz.mediator.core.RequestHandler;
import lombok.SneakyThrows;

@Component
public class ReadSKFormatBenefitsQueryHandler implements RequestHandler<ReadSKFormatBenefitsQuery, List<Benefit>> {

	@Autowired
	private ISKFormatRepository formatRepository;

	@Override
	@SneakyThrows
	public List<Benefit> handle(ReadSKFormatBenefitsQuery query) {
		var thFormat = formatRepository.getSKFormat().orElse(new SKFormat());
		if (thFormat.getBeneficios() == null) {
			thFormat.setBeneficios(new ArrayList<>());
		}
		return thFormat.getBeneficios();

	}

}
