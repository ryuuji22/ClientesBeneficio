package com.comohogar.benefit.application.queries;

import java.util.List;

import com.comohogar.benefit.domain.entities.Benefit;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReadSKFormatBenefitsQuery implements Request<List<Benefit>> {


}
