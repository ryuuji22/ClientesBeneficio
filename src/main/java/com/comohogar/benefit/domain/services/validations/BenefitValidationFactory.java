package com.comohogar.benefit.domain.services.validations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.comohogar.benefit.domain.enums.GroupType;

public class BenefitValidationFactory {

	private BenefitValidationFactory() {

	}

	static Map<String, BaseBenefitValidation> validatorsMap = new HashMap<>();
	static {
		validatorsMap.put(GroupType.SK.toString(), new SKBenefitExistsValidationService());
		validatorsMap.put(GroupType.TH.toString(), new THBenefitExistsValidationService());

	}

	public static Optional<BaseBenefitValidation> getValidator(String type) {
		return Optional.ofNullable(validatorsMap.get(type));
	}

}
