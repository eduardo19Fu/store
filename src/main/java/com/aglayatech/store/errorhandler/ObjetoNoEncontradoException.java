package com.aglayatech.store.errorhandler;

public class ObjetoNoEncontradoException extends RuntimeException {

	
	public ObjetoNoEncontradoException(String id) {
		super("Objeto con ID: ".concat(id).concat(" no fue encontrado en la base de datos."));
	}

	private static final long serialVersionUID = 1L;

}
