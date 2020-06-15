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
import javax.persistence.Transient;

@Entity
@Table(name = "documento")
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtransaccion;
	private Integer noDocumento;
	private Date fechaEmision;
	private Double total;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idvendedor")
	private Usuario usuario;
	private String serie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado")
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoDocumento")
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
