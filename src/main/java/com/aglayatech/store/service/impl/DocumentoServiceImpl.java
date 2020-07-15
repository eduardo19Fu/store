package com.aglayatech.store.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.store.errorhandler.ObjetoNoEncontradoException;
import com.aglayatech.store.model.Documento;
import com.aglayatech.store.model.TipoDocumento;
import com.aglayatech.store.repository.DocumentoRepository;
import com.aglayatech.store.service.IDocumentoService;

@Service
public class DocumentoServiceImpl implements IDocumentoService {

	@Autowired
	private DocumentoRepository repoDocumento;

	@Override
	public List<Documento> buscarTodos(TipoDocumento tipoDocumento) {
		return repoDocumento.findByTipoDocumentoOrderByIdtransaccionAsc(tipoDocumento);
	}

	@Override
	public List<Documento> bucarPorFecha(TipoDocumento tipoDocumento, Date fechaEmision) {
		return repoDocumento.findByFechaEmision(tipoDocumento, fechaEmision);
	}

	@Override
	public List<Documento> buscarPorFechas(TipoDocumento tipoDocumento, Date fechaInicio, Date fechaFin) {
		return repoDocumento.findByFechas(tipoDocumento, fechaInicio, fechaFin);
	}

	@Override
	public Documento buscarPorId(Long idtransaccion) {
		Optional<Documento> optional = repoDocumento.findById(idtransaccion);
		return optional.orElseThrow(() -> new ObjetoNoEncontradoException(idtransaccion.toString()));
	}

	@Override
	public void guardar(Documento documento) {
		repoDocumento.save(documento);
	}

	@Override
	public Long documentoMaxTransaccion() {
		return repoDocumento.documentoMaxTransaccion();
	}

}
