package com.aglayatech.store.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ordendespacho")
public class OrdenDespacho implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idorden;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado")
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idorden")
	private List<DetalleOrden> items;
	
	public OrdenDespacho() {
		this.items = new ArrayList<DetalleOrden>();
	}

	public Long getIdorden() {
		return idorden;
	}

	public void setIdorden(Long idorden) {
		this.idorden = idorden;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleOrden> getItems() {
		return items;
	}

	public void setItems(List<DetalleOrden> items) {
		this.items = items;
	}
	
	public void addItems(DetalleOrden item) {
		this.items.add(item);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "OrdenDespacho [idorden=" + idorden + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ ", usuario=" + usuario + "]";
	}

}
