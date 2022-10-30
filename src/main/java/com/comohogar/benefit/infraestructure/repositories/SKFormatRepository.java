/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comohogar.benefit.infraestructure.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;

import com.comohogar.benefit.domain.entities.SKFormat;
import com.comohogar.benefit.domain.interfaces.repositories.ISKFormatRepository;
import com.comohogar.benefit.infraestructure.consumer.WebClientTemplate;

/**
 *
 * @author diego
 */
@Repository
public class SKFormatRepository implements ISKFormatRepository {

	@Value("${files.sk}")
	private String skFile;

	@Autowired
	private WebClientTemplate clientTemplate;

	@Override
	public Optional<SKFormat> getSKFormat() {
		var skFormat = clientTemplate.genericGet(skFile, SKFormat.class, MediaType.APPLICATION_JSON);
		return Optional.of(skFormat);
	}

}
