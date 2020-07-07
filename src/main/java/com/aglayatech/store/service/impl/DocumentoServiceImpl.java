package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aglayatech.store.errorhandler.ObjetoNoEncontradoException;
import com.aglayatech.store.model.Documento;
import com.aglayatech.store.repository.DocumentoRepository;
import com.aglayatech.store.service.IDocumentoService;

@Service
public class DocumentoServiceImpl implements IDocumentoService {

	@Autowired
	private DocumentoRepository repoDocumento;
	
	@Override
	public List<Documento> buscarTodasFacturas(Integer tipoDocumento) {
		return repoDocumento.findAll(Sort.by(Direction.ASC, "idtransaccion"));
	}

	@Override
	public List<Documento> buscarTodasProformas(Integer tipoDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Documento buscarPorId(Integer idtransaccion) {
		Optional<Documento> optional = repoDocumento.findById(idtransaccion);
		return optional.orElseThrow(() -> new ObjetoNoEncontradoException(String.valueOf(idtransaccion)));
	}

	@Override
	public void guardar(Documento documento) {
		// TODO Auto-generated method stub

	}

}
