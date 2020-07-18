package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> buscarTodos();
	public Usuario buscarPorId(Integer idusuario);

}
