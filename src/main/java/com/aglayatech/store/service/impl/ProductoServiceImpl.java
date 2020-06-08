package com.aglayatech.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.store.model.Producto;
import com.aglayatech.store.repository.ProductoRepository;
import com.aglayatech.store.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoRepository repoProducto;

	@Override
	public List<Producto> buscarTodos() {
		return repoProducto.findAll();
	}

	@Override
	public Producto buscarPorId(String codigo) {
		return repoProducto.findByCodigo(codigo);
	}

	@Override
	public void guardar(Producto producto) {
		repoProducto.save(producto);

	}

}
