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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("clients/{id}")
	@ApiOperation(value = "Get a client by id", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The client information"),
			@ApiResponse(code = 400, message = "The client was not found") })
	@ApiImplicitParam(name = "id", example = "1", dataType = "long")
	public ResponseEntity<JsonDTO<ClientDTO>> index(@PathVariable Long id) {
		return new ResponseEntity<>(new JsonDTO<>(clientService.getClient(id)), HttpStatus.OK);
	}

}
