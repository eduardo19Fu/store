package com.aglayatech.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.store.model.DetalleOrden;
import com.aglayatech.store.model.OrdenDespacho;
import com.aglayatech.store.model.Producto;
import com.aglayatech.store.model.Usuario;
import com.aglayatech.store.service.IEstadoService;
import com.aglayatech.store.service.IOrdenDespachoService;
import com.aglayatech.store.service.IProductoService;
import com.aglayatech.store.service.IUsuarioService;

@Controller
@RequestMapping(value = "/dispatch")
public class OrdenDespachoController {
	
	@Autowired
	private IOrdenDespachoService serviceOrdenes;
	
	@Autowired
	private IProductoService serviceProductos;
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IEstadoService serviceEstado;

	@GetMapping(value = "/index")
	public String index(Model model) {
		List<OrdenDespacho> orders = serviceOrdenes.buscarTodos();
		model.addAttribute("orders", orders);
		return "pages/dispatch/list";
	}
	
	@GetMapping(value = "/create")
	public String create(OrdenDespacho ordenDespacho) {
		return "pages/dispatch/form";
	}
	
	@PostMapping(value = "/save")
	public String save(OrdenDespacho ordenDespacho,
						@RequestParam(name = "item_id[]", required = false) Long[] itemId,
						@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad,
						RedirectAttributes attributes) {
		
		for(int i = 0; i < itemId.length; i++) {
			Producto producto = serviceProductos.buscarPorId(itemId[i].intValue());
			DetalleOrden linea = new DetalleOrden();
			
			linea.setProducto(producto);
			linea.setCantidad(cantidad[i]);
			linea.setStuckTiendAnterior(producto.getStucktienda());
			linea.setStuckBodegaAnterior(producto.getStuckbodega());
			
			ordenDespacho.addItems(linea);
			
			producto.setStuckbodega(linea.calcularStuckBodega());
			producto.setStucktienda(linea.calcularStuckTienda());
			serviceProductos.guardar(producto);
		}
		
		ordenDespacho.setEstado(serviceEstado.buscarPorId(12));
		serviceOrdenes.guardar(ordenDespacho);
		return "redirect:/dispatch/index";
	}
	
	@ModelAttribute
	public void usuarios(Model model) {
		List<Usuario> usuarios = serviceUsuario.buscarTodos();
		model.addAttribute("usuarios", usuarios);
	}
	
	@GetMapping(value = "/load-products/{term}", produces = "application/json")
	public @ResponseBody List<Producto> cargarProductos(@PathVariable("term") String term) {
		return serviceProductos.buscarPorCodigoONombre(term);
	}
	
}
