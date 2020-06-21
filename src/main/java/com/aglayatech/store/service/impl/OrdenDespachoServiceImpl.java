package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aglayatech.store.model.OrdenDespacho;
import com.aglayatech.store.repository.OrdenDespachoRepository;
import com.aglayatech.store.service.IOrdenDespachoService;

/*
 * Clase de Implementación del servicio
 * */
@Service
public class OrdenDespachoServiceImpl implements IOrdenDespachoService {

	@Autowired
	private OrdenDespachoRepository repoOrden; // Declaración de objeto de repositorio para la clase modelo Orden Despacho
	
	// Implementacion del metodo buscarTodos()
	@Override
	public List<OrdenDespacho> buscarTodos() {
		return repoOrden.findAll(Sort.by(Direction.ASC, "idorden"));
	}

	// Implementación del metodo buscarPorId()
	@Override
	public OrdenDespacho buscarPorId(Integer idorden) {
		Optional<OrdenDespacho> optional = repoOrden.findById(idorden);
		if(optional.isPresent()){
			return optional.get();
		}else {
			return null;
		}
	}

	// Implementación del metodo guardar()
	@Override
	public void guardar(OrdenDespacho ordenDespacho) {
		repoOrden.save(ordenDespacho);
	}

	// Implementación del metodo eliminar()
	@Override
	public void eliminar(Integer idorden) {
		repoOrden.deleteById(idorden);
	}

}
