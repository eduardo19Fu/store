package com.aglayatech.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.store.model.Cliente;
import com.aglayatech.store.service.IClienteService;

@Controller
@RequestMapping(value = "/clients")
public class ClienteController {
	
	@Autowired
	private IClienteService serviceClient;
	
	@GetMapping(value = "/index")
	public String clientesIndex(Model model) {
		List<Cliente> clients = serviceClient.buscarTodos();
		model.addAttribute("clients", clients);
		return "pages/clients/list";
	}
	
	@GetMapping(value = "/create")
	public String create(Cliente cliente) {
		return "pages/clients/formClient";
	}
	
	@PostMapping(value = "/save")
	public String save(Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		serviceClient.guardar(cliente);
		attributes.addFlashAttribute("message", "Client was successfully register!");
		return "redirect:/clients/index";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") int idcliente, Model model) {
		Cliente client = serviceClient.buscarPorId(idcliente);
		model.addAttribute("cliente", client);
		return "pages/clients/formClient";
	}

}
