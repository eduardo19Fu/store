package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.store.model.Cliente;
import com.aglayatech.store.repository.ClienteRepository;
import com.aglayatech.store.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteRepository repoCliente;

	@Override
	public List<Cliente> buscarTodos() {
		return repoCliente.findAll();
	}

	@Override
	public Cliente buscarPorId(Integer idcliente) {
		Optional<Cliente> optional = repoCliente.findById(idcliente);
		
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Cliente buscarPorNit(String nit) {
		return repoCliente.findByNit(nit);
	}

	@Override
	public void guardar(Cliente cliente) {
		repoCliente.save(cliente);
	}

}
