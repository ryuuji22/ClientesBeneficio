package com.comohogar.benefit.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SKFormat {
	@JsonProperty(value = "sk_formato")
	private List<Benefit> beneficios;

}
