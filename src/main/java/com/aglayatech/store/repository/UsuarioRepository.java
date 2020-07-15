package com.aglayatech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglayatech.store.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
