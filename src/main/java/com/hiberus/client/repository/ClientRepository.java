package com.hiberus.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiberus.client.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
