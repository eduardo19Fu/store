package com.aglayatech.store.service;

import java.util.List;
import com.aglayatech.store.model.Usuario;
import com.aglayatech.store.model.UsuarioCorrelativo;

public interface IUsuarioCorrelativoService {
	
	public List<UsuarioCorrelativo> buscarTodos();
	public UsuarioCorrelativo buscarPorId(Long idcorrelativo);
	public UsuarioCorrelativo buscarPorUsuario(Usuario usuario);
	public void guardar(UsuarioCorrelativo usuarioCorrelativo);
	public void eliminar(Long idcorrelativo);

}
