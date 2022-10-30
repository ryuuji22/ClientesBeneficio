/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comohogar.benefit.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comohogar.benefit.application.queries.ReadSKFormatBenefitsQuery;
import com.comohogar.benefit.application.queries.ReadTHFormatBenefitsQuery;
import com.comohogar.benefit.domain.entities.Benefit;

import io.jkratz.mediator.core.Mediator;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/api/benefit")
@Slf4j
public class BenefitController {

	@Autowired
	private Mediator mediator;

	@GetMapping("/th")
	public ResponseEntity<List<String>> readTHBenefits() {
		var query = new ReadTHFormatBenefitsQuery();
		log.info("----- Sending Query: {} ", query.getClass().getName());
		return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
	}

	@GetMapping("/sk")
	public ResponseEntity<List<Benefit>> readSKBenefits() {
		var query = new ReadSKFormatBenefitsQuery();
		log.info("----- Sending Query: {} ", query.getClass().getName());
		return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
	}

}
