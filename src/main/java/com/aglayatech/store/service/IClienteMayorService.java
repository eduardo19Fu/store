package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.ClienteMayor;

public interface IClienteMayorService {
	
	List<ClienteMayor> buscarTodos();
	ClienteMayor buscarPorId(Integer idclientemayor);
	ClienteMayor buscarPorNit(String nit);
	void guardar(ClienteMayor clientemayor);

}
