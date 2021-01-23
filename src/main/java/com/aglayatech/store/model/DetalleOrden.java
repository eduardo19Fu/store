package com.aglayatech.store.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleorden")
public class DetalleOrden implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetalle;

	private Integer cantidad;

	@Column(name = "stuck_bodega_anterior")
	private Integer stuckBodegaAnterior;

	@Column(name = "stuck_tienda_anterior")
	private Integer stuckTiendAnterior;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproducto")
	private Producto producto;

	public Long getIddetalle() {
		return iddetalle;
	}

	public void setIddetalle(Long iddetalle) {
		this.iddetalle = iddetalle;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getStuckBodegaAnterior() {
		return stuckBodegaAnterior;
	}

	public void setStuckBodegaAnterior(Integer stuckBodegaAnterior) {
		this.stuckBodegaAnterior = stuckBodegaAnterior;
	}

	public Integer getStuckTiendAnterior() {
		return stuckTiendAnterior;
	}

	public void setStuckTiendAnterior(Integer stuckTiendAnterior) {
		this.stuckTiendAnterior = stuckTiendAnterior;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Integer calcularStuckBodega() {
		int stuckBodegaActual = producto.getStuckbodega();
		int stuckBodegaNuevo = stuckBodegaActual - this.cantidad;
		return stuckBodegaNuevo;
	}
	
	public Integer calcularStuckTienda() {
		int stuckTiendaActual = producto.getStucktienda();
		int stuckTiendaNuevo = stuckTiendaActual + this.cantidad;
		return stuckTiendaNuevo;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "DetalleOrden [iddetalle=" + iddetalle + ", cantidad=" + cantidad + ", stuckBodegaAnterior="
				+ stuckBodegaAnterior + ", stuckTiendAnterior=" + stuckTiendAnterior + ", producto=" + producto + "]";
	}

}
