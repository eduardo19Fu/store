package com.aglayatech.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aglayatech.store.model.Usuario;
import com.aglayatech.store.model.UsuarioCorrelativo;

public interface UsuarioCorrelativoRepository extends JpaRepository<UsuarioCorrelativo, Long> {
	
	@Query("Select u from UsuarioCorrelativo u where u.usuario = :usuario and u.estado = 8")
	Optional<UsuarioCorrelativo> findByIdusuario(@Param("usuario") Usuario usuario);

}
