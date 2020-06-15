package com.aglayatech.store.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrol;
	private String rol;
	private String descripcion;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado")
	private Estado estado;

	public Integer getIdrol() {
		return idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Rol [idrol=" + idrol + ", rol=" + rol + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

}
