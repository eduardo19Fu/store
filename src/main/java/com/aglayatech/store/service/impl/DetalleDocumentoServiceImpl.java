package com.aglayatech.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.store.model.DetalleDocumento;
import com.aglayatech.store.repository.DetalleDocumentoRepository;
import com.aglayatech.store.service.IDetalleDocumentoService;

@Service
public class DetalleDocumentoServiceImpl implements IDetalleDocumentoService {

	@Autowired
	private DetalleDocumentoRepository repoDetalle;
	
	@Override
	public void guardar(DetalleDocumento item) {
		repoDetalle.save(item);
	}

}
