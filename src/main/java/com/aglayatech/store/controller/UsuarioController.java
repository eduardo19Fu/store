package com.aglayatech.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.store.model.Estado;
import com.aglayatech.store.model.Usuario;
import com.aglayatech.store.model.UsuarioCorrelativo;
import com.aglayatech.store.service.IEstadoService;
import com.aglayatech.store.service.IUsuarioCorrelativoService;
import com.aglayatech.store.service.IUsuarioService;

@Controller
@RequestMapping(value = "/users")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceUsuario;
		
	@Autowired
	private IUsuarioCorrelativoService serviceCorrelativos;
	
	@Autowired
	private IEstadoService serviceEstado;
	
	/*
	 *
	 * Controladores para la parte de correlativos
	 * 
	 */
	
	@GetMapping(value = "/correlatives/index")
	public String correlatives(Model model) {
		List<UsuarioCorrelativo> correlatives = serviceCorrelativos.buscarTodos();
		model.addAttribute("correlatives", correlatives);
		return "pages/correlatives/list";
	}
	
	@GetMapping(value = "/correlatives/create")
	public String createCorrelatives(UsuarioCorrelativo usuarioCorrelativo) {
		return "pages/correlatives/form";
	}
	
	@PostMapping(value = "/correlatives/save")
	public String saveCorrelative(UsuarioCorrelativo usuarioCorrelativo, RedirectAttributes attributes, BindingResult result) {
		
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
		}
		
		usuarioCorrelativo.setCorrelativoActual(usuarioCorrelativo.getCorrelativoInicial());
		serviceCorrelativos.guardar(usuarioCorrelativo);
		attributes.addFlashAttribute("message", "Correlative was successfuly register!");
		return "redirect:/users/correlatives/index";
	}
	
	@GetMapping(value = "/correlatives/edit/{id}")
	public String editCorrelative(@PathVariable("id") Long idcorrelativo, Model model) {
		UsuarioCorrelativo usuarioCorrelativo = serviceCorrelativos.buscarPorId(idcorrelativo);
		model.addAttribute("usuarioCorrelativo", usuarioCorrelativo);
		return "pages/correlatives/form";
	}
	
	@GetMapping(value = "/correlatives/delete/{id}")
	public String deleteCorrelative(@PathVariable("id") Long idcorrelativo, RedirectAttributes attributes) {
		serviceCorrelativos.eliminar(idcorrelativo);
		attributes.addFlashAttribute("message", "El registro fue eliminado con éxito!");
		return "redirect:/users/correlatives/index";
	}
	
	/*
	 * Model attributes a nivel de clase
	 *
	 */
	
	@ModelAttribute
	public void users(Model model) {
		List<Usuario> users = serviceUsuario.buscarTodos();
		model.addAttribute("users", users);
	}
	
	@ModelAttribute
	public void estates(Model model) {
		List<Estado> status = serviceEstado.buscarTodos("Correlativos");
		model.addAttribute("status", status);
	}

}
