package com.aglayatech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglayatech.store.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
