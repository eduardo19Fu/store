package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aglayatech.store.errorhandler.ObjetoNoEncontradoException;
import com.aglayatech.store.model.TipoDocumento;
import com.aglayatech.store.repository.TipoDocumentoRepository;
import com.aglayatech.store.service.ITipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository repoTipoDocumento;
	
	@Override
	public List<TipoDocumento> buscarTodos() {
		return repoTipoDocumento.findAll(Sort.by(Direction.ASC, "nombre"));
	}

	@Override
	public TipoDocumento buscarPorId(Integer idtipoDocumento) {
		Optional<TipoDocumento> optional = repoTipoDocumento.findById(idtipoDocumento);
	
		return optional.orElseThrow(() -> new ObjetoNoEncontradoException(String.valueOf(idtipoDocumento)));
	}

	@Override
	public void guardar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub

	}

}
