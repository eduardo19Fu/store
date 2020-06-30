package com.aglayatech.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aglayatech.store.model.Documento;
import com.aglayatech.store.service.IDocumentoService;

@Controller
@RequestMapping("/documents")
public class DocumentoController {
	
	@Autowired
	private IDocumentoService serviceDocumento;
	
	@GetMapping(value = "/bills/index")
	public String billsIndex() {
		return "";
	}
	
	@GetMapping(value = "/factura/{id}")
	public String buscarFactura(@PathVariable("id") Integer idtransaccion, Model model) {
		Documento documento = serviceDocumento.buscarPorId(idtransaccion);
		model.addAttribute("documento", documento);
		return "pages/vistafactura";
	}

}
