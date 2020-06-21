package com.aglayatech.store.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalledocumento")
public class DetalleDocumento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalle;

	private Integer cantidad;
	private Double subtotal;
	private Double descuento;
	private String serie;
	private Double nprecioVenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproducto")
	private Producto producto;

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Double getNprecioVenta() {
		return nprecioVenta;
	}

	public void setNprecioVenta(Double nprecioVenta) {
		this.nprecioVenta = nprecioVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Double calcularSubtotal() {
		return this.cantidad.doubleValue() * producto.getPrecioventa();
	}
	
	public Double calcularDescuento(Double valorDescuento) {
		Double porcentajeDescuento = valorDescuento/100; 
		return null;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "DetalleDocumento [idDetalle=" + idDetalle + ", cantidad=" + cantidad + ", subtotal=" + subtotal
				+ ", descuento=" + descuento + ", serie=" + serie + ", nprecioVenta=" + nprecioVenta + ", producto="
				+ producto + "]";
	}

}
