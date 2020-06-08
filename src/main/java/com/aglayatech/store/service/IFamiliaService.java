package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.Familia;

public interface IFamiliaService {
	
	List<Familia> buscarTodos();
	Familia buscarPorId(Integer idfamilia);
	void guardar(Familia familia);

}
