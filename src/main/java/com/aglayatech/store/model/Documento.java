package com.aglayatech.store.model;

import java.util.Date;

public class Documento {

	private Integer idtransaccion;
	private Integer noDocumento;
	private Date fechaEmision;
	private Double total;
	private Cliente cliente;
	private Usuario usuario;
	private String serie;
	private Estado estado;
	private TipoDocumento tipoDocumento;

	public Integer getIdtransaccion() {
		return idtransaccion;
	}

	public void setIdtransaccion(Integer idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	public Integer getNoDocumento() {
		return noDocumento;
	}

	public void setNoDocumento(Integer noDocumento) {
		this.noDocumento = noDocumento;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}
