package com.aglayatech.store.service;

import java.util.Date;
import java.util.List;

import com.aglayatech.store.model.Documento;
import com.aglayatech.store.model.Estado;
import com.aglayatech.store.model.TipoDocumento;

public interface IDocumentoService {

	List<Documento> buscarTodos(TipoDocumento tipoDocumento);

	List<Documento> bucarPorFecha(TipoDocumento tipoDocumento, Date fechaEmision);

	List<Documento> buscarPorFechas(TipoDocumento tipoDocumento, Date fechaInicio, Date fechaFin);

	Documento buscarPorId(Long idtransaccion);

	Long documentoMaxTransaccion();

	void guardar(Documento documento);
	
	Long countFacturas(TipoDocumento tipoDocumento, Estado estado);

}
