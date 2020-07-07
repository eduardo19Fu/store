package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.Documento;

public interface IDocumentoService {
	
	List<Documento> buscarTodasFacturas(Integer tipoDocumento);
	List<Documento> buscarTodasProformas(Integer tipoDocumento);
	Documento buscarPorId(Integer idtransaccion);
	void guardar(Documento documento);

}
