package com.hiberus.client.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.client.model.Client;
import com.hiberus.client.repository.ClientRepository;
import com.hiberus.client.service.ClientService;
import com.hiberus.commons.dto.ClientDTO;
import com.hiberus.commons.exception.NotFoundException;

import lombok.extern.java.Log;

@Log
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ClientDTO getClient(Long id) {
		log.info("--- Starting Service ---");
		log.info(String.format("Getting information for id : %s", id));
		Optional<Client> client = clientRepository.findById(id);

		if (!client.isPresent())
			throw new NotFoundException("client");

		log.info("--- Finishing Service ---");
		return new ClientDTO(client.get().getId(), client.get().getFirstName(), client.get().getLastName(),
				client.get().getAddress(), client.get().getIdentification());
	}

}
