package com.aglayatech.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aglayatech.store.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query("Select p from Producto p where p.nombreproducto like %:texto%")
	public List<Producto> findByCodigoOrNombreproducto(@Param("texto") String texto);

}
