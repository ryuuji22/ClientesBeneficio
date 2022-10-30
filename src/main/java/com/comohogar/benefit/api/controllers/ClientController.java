/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comohogar.benefit.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comohogar.benefit.application.command.create.CreateClientCommand;
import com.comohogar.benefit.application.queries.ReadAllClientsQuery;
import com.comohogar.benefit.domain.entities.Client;

import io.jkratz.mediator.core.Mediator;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/api/client")
@Slf4j
public class ClientController {

	@Autowired
	private Mediator mediator;

	@GetMapping
	public ResponseEntity<List<Client>> readClients() {
		var query = new ReadAllClientsQuery();
		log.info("----- Sending Query: {} ", query.getClass().getName());
		return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> createClient(@Valid @RequestBody CreateClientCommand command) {

		log.info("------ Sending Command: {} ", command.getClass().getName());

		this.mediator.dispatch(command);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
