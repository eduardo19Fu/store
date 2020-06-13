package com.aglayatech.store.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.store.model.Estado;
import com.aglayatech.store.model.Fabricante;
import com.aglayatech.store.model.Familia;
import com.aglayatech.store.model.Producto;
import com.aglayatech.store.service.IEstadoService;
import com.aglayatech.store.service.IFabricanteService;
import com.aglayatech.store.service.IFamiliaService;
import com.aglayatech.store.service.IProductoService;

@Controller
@RequestMapping(value = "/products")
public class ProductoController {
	
	@Autowired
	private IProductoService serviceProducto;
	
	@Autowired
	private IFabricanteService serviceFabricante;
	
	@Autowired
	private IFamiliaService serviceFamilia;
	
	@Autowired
	private IEstadoService serviceEstado;
	
	@GetMapping(value = "/index")
	public String productosIndex(Model model) {
		List<Producto> lista = serviceProducto.buscarTodos();
		model.addAttribute("prductos", lista);
		return "pages/products/list";
	}
	
	@GetMapping(value = "/create")
	public String create(Producto producto) {
		return "pages/products/formProduct";
	}
	
	@PostMapping(value = "/save")
	public String save(Producto producto, BindingResult result, RedirectAttributes attributes) {
		serviceProducto.guardar(producto);
		return "redirect:/products/index";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") String codigo, Model model) {
		Producto product = serviceProducto.buscarPorId(codigo);
		model.addAttribute("product",product);
		return "pages/products/fromProduct";
	}
	
	@ModelAttribute
	public void getFabricantes(Model model) {
		List<Fabricante> makers = serviceFabricante.buscarTodos();
		model.addAttribute("makers", makers);
	}
	
	@ModelAttribute
	public void getFamilias(Model model) {
		List<Familia> families = serviceFamilia.buscarTodos();
		model.addAttribute("families",families);
	}
	
	@ModelAttribute
	public void getEstados(Model model) {
		List<Estado> states = serviceEstado.buscarTodos();
		model.addAttribute("states", states);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
