package com.aglayatech.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientemayor")
public class ClienteMayor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idclientemayor;
	private String telefono;
	private String email;
	
	@OneToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	public Integer getIdclientemayor() {
		return idclientemayor;
	}

	public void setIdclientemayor(Integer idclientemayor) {
		this.idclientemayor = idclientemayor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
