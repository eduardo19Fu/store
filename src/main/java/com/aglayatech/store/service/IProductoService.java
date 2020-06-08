package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.Producto;

public interface IProductoService {
	
	List<Producto> buscarTodos();
	Producto buscarPorId(String codigo);
	void guardar(Producto producto);

}
