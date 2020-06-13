package com.aglayatech.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fabricante")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idfabricante;
	private String nombrefabricante;
	private String observaciones;

	public Integer getIdfabricante() {
		return idfabricante;
	}

	public void setIdfabricante(Integer idfabricante) {
		this.idfabricante = idfabricante;
	}

	public String getNombrefabricante() {
		return nombrefabricante;
	}

	public void setNombrefabricante(String nombrefabricante) {
		this.nombrefabricante = nombrefabricante;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
