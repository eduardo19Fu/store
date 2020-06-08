package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.Fabricante;

public interface IFabricanteService {
	
	List<Fabricante> buscarTodos();
	Fabricante buscarPorId(Integer idfabricante);
	void guardar(Fabricante fabricante);

}
