package com.aglayatech.store.model;

import java.util.Date;

public class Producto {

	private String codigo;
	private String nombreproducto;
	private String preciocompra;
	private String precioventa;
	private Date fechacompra;
	private Date fechavenicimiento;
	private Fabricante fabricante;
	private Familia familia;
	private Integer stuckTienda;
	private Integer stuckBodega;
	private Double porcentajeganancia;
	private Integer stuckMinimoTienda;
	private Integer stuckMinimoBodega;
	private Estado estado;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public String getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(String preciocompra) {
		this.preciocompra = preciocompra;
	}

	public String getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(String precioventa) {
		this.precioventa = precioventa;
	}

	public Date getFechacompra() {
		return fechacompra;
	}

	public void setFechacompra(Date fechacompra) {
		this.fechacompra = fechacompra;
	}

	public Date getFechavenicimiento() {
		return fechavenicimiento;
	}

	public void setFechavenicimiento(Date fechavenicimiento) {
		this.fechavenicimiento = fechavenicimiento;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Integer getStuckTienda() {
		return stuckTienda;
	}

	public void setStuckTienda(Integer stuckTienda) {
		this.stuckTienda = stuckTienda;
	}

	public Integer getStuckBodega() {
		return stuckBodega;
	}

	public void setStuckBodega(Integer stuckBodega) {
		this.stuckBodega = stuckBodega;
	}

	public Double getPorcentajeganancia() {
		return porcentajeganancia;
	}

	public void setPorcentajeganancia(Double porcentajeganancia) {
		this.porcentajeganancia = porcentajeganancia;
	}

	public Integer getStuckMinimoTienda() {
		return stuckMinimoTienda;
	}

	public void setStuckMinimoTienda(Integer stuckMinimoTienda) {
		this.stuckMinimoTienda = stuckMinimoTienda;
	}

	public Integer getStuckMinimoBodega() {
		return stuckMinimoBodega;
	}

	public void setStuckMinimoBodega(Integer stuckMinimoBodega) {
		this.stuckMinimoBodega = stuckMinimoBodega;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
