package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.Estado;

public interface IEstadoService {
	
	List<Estado> buscarTodos(String categoria);
	Estado buscarPorId(Integer idestado);
	Estado buscarPorEstado(String nombreestado);
	
}
