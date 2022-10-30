/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comohogar.benefit.infraestructure.repositories;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;

import com.comohogar.benefit.domain.entities.THFormat;
import com.comohogar.benefit.domain.interfaces.repositories.ITHFormatRepository;
import com.comohogar.benefit.infraestructure.consumer.WebClientTemplate;

/**
 *
 * @author diego
 */
@Repository
public class THFormatRepository implements ITHFormatRepository {

	@Value("${files.th}")
	private String thFile;

	@Autowired
	private WebClientTemplate clientTemplate;

	@Override
	public Optional<THFormat> getTHFormat() throws IOException {
		var thFormat = clientTemplate.genericGet(thFile, THFormat.class, MediaType.APPLICATION_XML);
		return Optional.of(thFormat);
	}

}
