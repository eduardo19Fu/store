package com.aglayatech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglayatech.store.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findByNit(String nit);

}
