package com.aglayatech.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aglayatech.store.model.Estado;
import com.aglayatech.store.model.TipoDocumento;
import com.aglayatech.store.service.IDocumentoService;
import com.aglayatech.store.service.IEstadoService;
import com.aglayatech.store.service.IProductoService;
import com.aglayatech.store.service.ITipoDocumentoService;
import com.aglayatech.store.service.IUsuarioService;

@Controller
@RequestMapping({"/home","/"})
public class HomeController {
	
	@Autowired
	private IProductoService serviceProducto;
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IDocumentoService serviceDocumento;
	
	@Autowired
	private IEstadoService serviceEstado;
	
	@Autowired
	private ITipoDocumentoService serviceTipoDocumento;
	
	@GetMapping
	public String mostrarHome(Model model) {
		
		// Buscar Estado por ID
		Estado estado = serviceEstado.buscarPorId(1);
		
		// Buscar TipoDocumento por ID
		TipoDocumento td = serviceTipoDocumento.buscarPorId(1);
		
		Integer totalProductos = serviceProducto.contarProductos();
		Long totalFacturas = serviceDocumento.countFacturas(td, estado);
		
		model.addAttribute("totalProductos", totalProductos); // Total de productos
		model.addAttribute("totalFacturas", totalFacturas); // Total de facturas no anuladas
		return "/home";
	}
	
}
