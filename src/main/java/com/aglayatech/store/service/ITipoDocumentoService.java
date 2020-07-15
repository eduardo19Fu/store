package com.aglayatech.store.service;

import java.util.List;

import com.aglayatech.store.model.TipoDocumento;

public interface ITipoDocumentoService {
	
	List<TipoDocumento> buscarTodos();
	TipoDocumento buscarPorId(Integer idtipoDocumento);
	void guardar();
	void eliminar();

}
