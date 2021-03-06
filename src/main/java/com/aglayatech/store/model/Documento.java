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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "documento")
public class Documento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtransaccion;

	@Column(name = "no_documento")
	private Integer noDocumento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_emision")
	private Date fechaEmision;

	private Double total;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	private String serie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado")
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_documento")
	private TipoDocumento tipoDocumento;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idtransaccion")
	private List<DetalleDocumento> detalleDocumento;

	public Documento() {
		this.detalleDocumento = new ArrayList<DetalleDocumento>();
	}

	@PrePersist
	public void prePersist() {
		this.fechaEmision = new Date();
	}

	public Long getIdtransaccion() {
		return idtransaccion;
	}

	public void setIdtransaccion(Long idtransaccion) {
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

	public List<DetalleDocumento> getDetalleDocumento() {
		return detalleDocumento;
	}

	public void setDetalleDocumento(List<DetalleDocumento> detalleDocumento) {
		this.detalleDocumento = detalleDocumento;
	}
	
	public void addDetalleDocumento(DetalleDocumento item) {
		this.detalleDocumento.add(item);
	}

	public Double calcularTotal() {
		Double total = 0.00;

		for (int i = 0; i < getDetalleDocumento().size(); i++) {
			total += detalleDocumento.get(i).calcularSubtotal();
		}

		return total;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Documento [idtransaccion=" + idtransaccion + ", noDocumento=" + noDocumento + ", fechaEmision="
				+ fechaEmision + ", total=" + total + ", cliente=" + cliente + ", usuario=" + usuario + ", serie="
				+ serie + ", estado=" + estado + ", tipoDocumento=" + tipoDocumento + ", detalleDocumento="
				+ detalleDocumento + "]";
	}

}
