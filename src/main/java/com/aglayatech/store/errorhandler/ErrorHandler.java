package com.aglayatech.store.errorhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError(Exception ex, Model model) {
		model.addAttribute("error","Error de Aritmetica");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/genericos";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatError(Exception ex, Model model) {
		model.addAttribute("error", "Error al tratar de convertir un texto a número!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/genericos";
	}
	
	@ExceptionHandler(ObjetoNoEncontradoException.class)
	public String objetoNoEncontradoError(Exception ex, Model model) {
		model.addAttribute("error", "Error: Objeto no encontrado!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/genericos";
	}

}
