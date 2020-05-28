package com.aglayatech.store.model;

public class ClienteMayor {

	private Integer idclientemayor;
	private String telefono;
	private String email;
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
