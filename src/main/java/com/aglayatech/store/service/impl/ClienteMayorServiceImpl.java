package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.store.model.ClienteMayor;
import com.aglayatech.store.repository.ClienteMayorRepository;
import com.aglayatech.store.service.IClienteMayorService;

@Service
public class ClienteMayorServiceImpl implements IClienteMayorService {
	
	@Autowired
	private ClienteMayorRepository repoClienteMayor;

	@Override
	public List<ClienteMayor> buscarTodos() {
		return repoClienteMayor.findAll();
	}

	@Override
	public ClienteMayor buscarPorId(Integer idclientemayor) {
		Optional<ClienteMayor> optional = repoClienteMayor.findById(idclientemayor);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public ClienteMayor buscarPorNit(String nit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(ClienteMayor clientemayor) {
		repoClienteMayor.save(clientemayor);
	}

}
