package com.aglayatech.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
