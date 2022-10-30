/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comohogar.benefit.infraestructure.consumer;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 *
 * @author diegohinojosa
 */

@Component
public class WebClientTemplate {

	@Autowired
	private RestTemplate restTemplate;

	private void setConverter(MediaType mediaType) {
		
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
		ObjectMapper objectMapper = new JsonMapper();
		if (mediaType.equals(MediaType.APPLICATION_XML)) {
			objectMapper = new XmlMapper();
		}
		converter.setObjectMapper(objectMapper);

		restTemplate.getMessageConverters().set(0, converter);
	}

	public <T> T genericGet(String url, Class<T> clazz, MediaType mediaType) {
		this.setConverter(mediaType);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(mediaType));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, clazz);
		return response.getBody();

	}

}
