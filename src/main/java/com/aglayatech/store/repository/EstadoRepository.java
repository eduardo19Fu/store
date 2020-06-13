package com.aglayatech.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aglayatech.store.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	Estado findByNombreestado(String estado);
	
	@Query("select e from Estado e where e.categoria = 'Producto' order by e.nombreestado asc")
	List<Estado> findAllStatus();
	
}
