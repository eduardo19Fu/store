package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.store.errorhandler.ObjetoNoEncontradoException;
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
		return optional.orElseThrow(() -> new ObjetoNoEncontradoException(String.valueOf(idfabricante)));
	}

	@Override
	public void guardar(Fabricante fabricante) {
		repoFabricante.save(fabricante);
	}

	@Override
	public void eliminar(Integer idfabricante) {
		repoFabricante.deleteById(idfabricante);
	}

}
