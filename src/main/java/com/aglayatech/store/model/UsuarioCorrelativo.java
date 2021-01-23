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
import javax.persistence.Transient;

@Entity
@Table(name = "usuario_correlativo")
public class UsuarioCorrelativo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcorrelativo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	private String serie;
	
	@Column(name = "correlativo_inicial")
	private Long correlativoInicial;
	@Column(name = "correlativo_final")
	private Long correlativoFinal;
	@Column(name = "correlativo_actual")
	private Long correlativoActual;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado")
	private Estado estado;
	
	@Transient
	private TipoDocumento tipoDocumento;
	

	public Long getIdcorrelativo() {
		return idcorrelativo;
	}

	public void setIdcorrelativo(Long idcorrelativo) {
		this.idcorrelativo = idcorrelativo;
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

	public Long getCorrelativoInicial() {
		return correlativoInicial;
	}

	public void setCorrelativoInicial(Long correlativoInicial) {
		this.correlativoInicial = correlativoInicial;
	}

	public Long getCorrelativoFinal() {
		return correlativoFinal;
	}

	public void setCorrelativoFinal(Long correlativoFinal) {
		this.correlativoFinal = correlativoFinal;
	}

	public Long getCorrelativoActual() {
		return correlativoActual;
	}

	public void setCorrelativoActual(Long correlativoActual) {
		this.correlativoActual = correlativoActual;
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
	
	// Método que devuelve el correlativo actualizado
	public Long aumentarCorrelativo() {
		 return (this.correlativoActual+1);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UsuarioCorrelativo [idcorrelativo=" + idcorrelativo + ", usuario=" + usuario + ", serie=" + serie
				+ ", correlativoInicial=" + correlativoInicial + ", correlativoFinal=" + correlativoFinal
				+ ", correlativoActual=" + correlativoActual + ", estado=" + estado + ", tipoDocumento=" + tipoDocumento
				+ "]";
	}

}
