package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.store.model.Estado;
import com.aglayatech.store.repository.EstadoRepository;
import com.aglayatech.store.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService {

	@Autowired
	private EstadoRepository repoEstado;
	
	@Override
	public List<Estado> buscarTodos(String categoria) {
		return repoEstado.findAllStatus(categoria);
	}

	@Override
	public Estado buscarPorId(Integer idestado) {
		Optional<Estado> optional = repoEstado.findById(idestado);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Estado buscarPorEstado(String estado) {
		return repoEstado.findByNombreEstado(estado);
	}

}
