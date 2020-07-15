package com.aglayatech.store.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproducto;
	private String codigo;
	private String nombreproducto;
	private Double preciocompra;
	private Double precioventa;

	@Temporal(TemporalType.DATE)
	private Date fechacompra;
	@Temporal(TemporalType.DATE)
	private Date fechavencimiento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfabricante")
	private Fabricante fabricante;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfamilia")
	private Familia familia;

	private Integer stucktienda;
	private Integer stuckbodega;
	private Double porcentajeganancia;
	private Integer stuckminimotienda;
	private Integer stuckminimobodega;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado")
	private Estado estado;

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

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

	public Double getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(Double preciocompra) {
		this.preciocompra = preciocompra;
	}

	public Double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}

	public Date getFechacompra() {
		return fechacompra;
	}

	public void setFechacompra(Date fechacompra) {
		this.fechacompra = fechacompra;
	}

	public Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Date fechavenicimiento) {
		this.fechavencimiento = fechavenicimiento;
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

	public Integer getStucktienda() {
		return stucktienda;
	}

	public void setStucktienda(Integer stuckTienda) {
		this.stucktienda = stuckTienda;
	}

	public Integer getStuckbodega() {
		return stuckbodega;
	}

	public void setStuckbodega(Integer stuckBodega) {
		this.stuckbodega = stuckBodega;
	}

	public Double getPorcentajeganancia() {
		return porcentajeganancia;
	}

	public void setPorcentajeganancia(Double porcentajeganancia) {
		this.porcentajeganancia = porcentajeganancia;
	}

	public Integer getStuckminimotienda() {
		return stuckminimotienda;
	}

	public void setStuckminimotienda(Integer stuckMinimoTienda) {
		this.stuckminimotienda = stuckMinimoTienda;
	}

	public Integer getStuckminimobodega() {
		return stuckminimobodega;
	}

	public void setStuckminimobodega(Integer stuckMinimoBodega) {
		this.stuckminimobodega = stuckMinimoBodega;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", codigo=" + codigo + ", nombreproducto=" + nombreproducto
				+ ", preciocompra=" + preciocompra + ", precioventa=" + precioventa + ", fechacompra=" + fechacompra
				+ ", fechavencimiento=" + fechavencimiento + ", fabricante=" + fabricante + ", familia=" + familia
				+ ", stucktienda=" + stucktienda + ", stuckbodega=" + stuckbodega + ", porcentajeganancia="
				+ porcentajeganancia + ", stuckminimotienda=" + stuckminimotienda + ", stuckminimobodega="
				+ stuckminimobodega + ", estado=" + estado + "]";
	}

}
