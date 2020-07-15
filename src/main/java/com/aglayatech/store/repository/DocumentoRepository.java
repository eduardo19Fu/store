package com.aglayatech.store.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aglayatech.store.model.Documento;
import com.aglayatech.store.model.TipoDocumento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
	
	// Busca todos los documentos según el tipo definido en el controlador.
	List<Documento> findByTipoDocumentoOrderByIdtransaccionAsc(TipoDocumento tipoDocumento);
	
	// Busca todos los documentos segun el tipo señalado y que fuesen emitido en la fecha proporcionada por el usuario
	@Query("Select d from Documento d where d.tipoDocumento = :tipo and date(fechaEmision) = :fecha")
	List<Documento> findByFechaEmision(@Param("tipo") TipoDocumento tipoDocumento, @Param("fecha") Date fechaEmision);
	
	// Busca todos los documentos segun el tipo señalado por cierto rango de fechas que el usuario proporciones
	@Query("Select d from Documento d where d.tipoDocumento = :tipo and date(d.fechaEmision) between :fechaInicio and :fechaFin")
	List<Documento> findByFechas(@Param("tipo") TipoDocumento tipoDocumento, @Param("fechaInicio") Date fechaInicio,@Param("fechaFin") Date fechaFin);
	
	// Recupera la transaccion maxima generada
	@Query("Select max(d.idtransaccion) from Documento d")
	Long documentoMaxTransaccion();
	
}
