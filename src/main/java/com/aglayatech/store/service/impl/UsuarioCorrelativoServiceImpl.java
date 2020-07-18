package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aglayatech.store.errorhandler.ObjetoNoEncontradoException;
import com.aglayatech.store.model.Usuario;
import com.aglayatech.store.model.UsuarioCorrelativo;
import com.aglayatech.store.repository.UsuarioCorrelativoRepository;
import com.aglayatech.store.service.IUsuarioCorrelativoService;

@Service
public class UsuarioCorrelativoServiceImpl implements IUsuarioCorrelativoService {

	@Autowired
	private UsuarioCorrelativoRepository repoCorrelativos;
	
	@Override
	public List<UsuarioCorrelativo> buscarTodos() {
		return repoCorrelativos.findAll(Sort.by(Direction.ASC, "idcorrelativo"));
	}

	@Override
	public UsuarioCorrelativo buscarPorId(Long idcorrelativo) {
		Optional<UsuarioCorrelativo> optional = repoCorrelativos.findById(idcorrelativo);
		return optional.orElseThrow(() -> new ObjetoNoEncontradoException(idcorrelativo.toString()));
	}

	@Override
	public void guardar(UsuarioCorrelativo usuarioCorrelativo) {
		repoCorrelativos.save(usuarioCorrelativo);

	}

	@Override
	public void eliminar(Long idcorrelativo) {
		repoCorrelativos.deleteById(idcorrelativo);
	}

	@Override
	public UsuarioCorrelativo buscarPorUsuario(Usuario usuario) {
		Optional<UsuarioCorrelativo> optional = repoCorrelativos.findByIdusuario(usuario);
		return optional.orElseThrow(() -> new ObjetoNoEncontradoException(usuario.getIdusuario().toString()));
	}

}
