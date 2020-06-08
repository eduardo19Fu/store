package com.aglayatech.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipodocumento")
public class TipoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtipodocumento;
	private String nombre;

	public Integer getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(Integer idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
