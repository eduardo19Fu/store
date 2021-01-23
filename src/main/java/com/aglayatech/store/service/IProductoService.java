package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.Producto;

public interface IProductoService {
	
	public List<Producto> buscarTodos();
	
	public Producto buscarPorId(Integer idproducto);
	
	public List<Producto> buscarPorCodigoONombre(String texto);
	
	public void guardar(Producto producto);
	
	public void eliminar(Integer idproducto);
	
	public Integer contarProductos();
	
}
