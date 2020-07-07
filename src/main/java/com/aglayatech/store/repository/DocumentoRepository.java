package com.aglayatech.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglayatech.store.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
	
	List<Documento> findByTipoDocumento(Integer idtipodocumento);
}
