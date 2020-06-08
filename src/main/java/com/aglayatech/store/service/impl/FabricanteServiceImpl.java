package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.store.model.Fabricante;
import com.aglayatech.store.repository.FabricanteRepository;
import com.aglayatech.store.service.IFabricanteService;

@Service
public class FabricanteServiceImpl implements IFabricanteService {
	
	@Autowired
	private FabricanteRepository repoFabricante;

	@Override
	public List<Fabricante> buscarTodos() {
		return repoFabricante.findAll();
	}

	@Override
	public Fabricante buscarPorId(Integer idfabricante) {
		Optional<Fabricante> optional = repoFabricante.findById(idfabricante);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public void guardar(Fabricante fabricante) {
		repoFabricante.save(fabricante);
	}

}
