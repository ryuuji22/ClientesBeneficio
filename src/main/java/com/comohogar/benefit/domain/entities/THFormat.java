package com.comohogar.benefit.domain.entities;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JacksonXmlRootElement(localName = "th_formato")
@Getter
@Setter
@NoArgsConstructor
public class THFormat {
	@JacksonXmlElementWrapper(useWrapping = true, localName = "beneficios")
	private List<String> beneficio;

}
