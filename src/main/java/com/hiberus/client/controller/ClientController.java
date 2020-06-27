package com.hiberus.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.client.service.ClientService;
import com.hiberus.commons.dto.ClientDTO;
import com.hiberus.commons.dto.JsonDTO;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("clients/{id}")
	public ResponseEntity<JsonDTO<ClientDTO>> index(@PathVariable Long id) {
		return new ResponseEntity<>(new JsonDTO<>(clientService.getClient(id)), HttpStatus.OK);
	}

}
