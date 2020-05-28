package com.aglayatech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglayatech.store.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

}
