package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.OrdenDespacho;

/**
 * Interface de Servicio para implementar operaciones correspondientes al modelo Orden Despacho.
 **/

public interface IOrdenDespachoService {
	
	List<OrdenDespacho> buscarTodos(); // Metodo de busqueda para todas las ordenes existentes
	OrdenDespacho buscarPorId(Integer idorden); // Metodo de busqueda para una entidad en partícular por ID
	void guardar(OrdenDespacho ordenDespacho); // Metodo que recibe y guarda la entidad
	void eliminar(Integer idorden); // Metodo que elimina segun el idorden proporcionado

}
