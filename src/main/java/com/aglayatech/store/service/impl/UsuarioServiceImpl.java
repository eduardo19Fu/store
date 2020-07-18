package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aglayatech.store.errorhandler.ObjetoNoEncontradoException;
import com.aglayatech.store.model.Usuario;
import com.aglayatech.store.repository.UsuarioRepository;
import com.aglayatech.store.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Override
	public List<Usuario> buscarTodos() {
		return repoUsuario.findAll(Sort.by(Direction.ASC, "idusuario"));
	}

	@Override
	public Usuario buscarPorId(Integer idusuario) {
		Optional<Usuario> optional = repoUsuario.findById(idusuario);
		return optional.orElseThrow(() -> new ObjetoNoEncontradoException(idusuario.toString()));
	}

}
