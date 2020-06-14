package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.Cliente;

public interface IClienteService {
	
	List<Cliente> buscarTodos();
	Cliente buscarPorId(Integer idcliente);
	Cliente buscarPorNit(String nit);
	void guardar(Cliente cliente);

}
