package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.NotaCredito;

public interface INotaCreditoService {
	
	List<NotaCredito> buscarTodos();
	NotaCredito buscarPorId(Integer idnota);
	void guardar(NotaCredito notaCredito);
	void eliminar(Integer idnotas);

}
