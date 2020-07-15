package com.aglayatech.store.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.store.model.Cliente;
import com.aglayatech.store.model.DetalleDocumento;
import com.aglayatech.store.model.Documento;
import com.aglayatech.store.model.Producto;
import com.aglayatech.store.model.TipoDocumento;
import com.aglayatech.store.model.Usuario;
import com.aglayatech.store.service.IClienteService;
import com.aglayatech.store.service.IDetalleDocumentoService;
import com.aglayatech.store.service.IDocumentoService;
import com.aglayatech.store.service.IEstadoService;
import com.aglayatech.store.service.IProductoService;
import com.aglayatech.store.service.ITipoDocumentoService;
import com.aglayatech.store.service.IUsuarioService;


@Controller
@RequestMapping("/documents")
public class DocumentoController {
	
	@Autowired
	private IDocumentoService serviceDocumento;
	
	@Autowired
	private ITipoDocumentoService serviceTipoDocumento;
	
	@Autowired
	private IClienteService serviceCliente;
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IProductoService serviceProducto;
	
	@Autowired
	private IEstadoService serviceEstado;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value = "/bills/index")
	public String billsIndex(Model model) {
		
		TipoDocumento tipoDocumento = serviceTipoDocumento.buscarPorId(1);
		List<Documento> bills = serviceDocumento.buscarTodos(tipoDocumento);
		
		model.addAttribute("bills", bills);
		return "pages/documents/bills/list";
	}
	
	@GetMapping(value = "/bills/create")
	public String createBill(Documento documento) {
		return "pages/documents/bills/form";
	}
	
	@PostMapping(value = "/bills/save")
	public String saveBill(Documento documento,
							BindingResult result,
							@RequestParam(name = "item_id[]", required = false) Long[] itemId, 
							@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad,
							@RequestParam(name = "total_importe[]", required = false) Double[] totalImporte,
							RedirectAttributes attributes) {
		
		var total = 0.0;
		
		documento.setNoDocumento(252525252);
		documento.setSerie("A");
		documento.setEstado(serviceEstado.buscarPorId(2));
		documento.setTipoDocumento(serviceTipoDocumento.buscarPorId(1));
		
		for(int i = 0; i < itemId.length; i++) {
			Producto producto = serviceProducto.buscarPorId(itemId[i].intValue());
			
			DetalleDocumento linea = new DetalleDocumento();
			
			linea.setProducto(producto);
			linea.setCantidad(cantidad[i]);
			linea.setSubtotal(linea.calcularSubtotal());
			linea.setDescuento(0.00);
			linea.setSerie("A");
			linea.setNprecioVenta(0.00);
			
			documento.addDetalleDocumento(linea);
			
			
			
			log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
		}
		
		total = documento.calcularTotal();
		documento.setTotal(total);
		serviceDocumento.guardar(documento);
		
		
		attributes.addFlashAttribute("mensaje", "Factura creada con éxito!");
		
		return "redirect:/documents/bills/index";
	}
	
	@GetMapping(value = "/quotes/index")
	public String quotesIndex(Model model) {
		
		TipoDocumento tipoDocumento = serviceTipoDocumento.buscarPorId(2);
		List<Documento> quotes = serviceDocumento.buscarTodos(tipoDocumento);
		
		model.addAttribute("quotes", quotes);
		return "";
	}
	
	
	/*@GetMapping("/prueba/busquedas")
	public String pruebaMetodos() {
		TipoDocumento tipo = serviceTipoDocumento.buscarPorId(1);
		List<Documento> bills = serviceDocumento.buscarTodos(tipo);
		for(Documento doc : bills) {
			System.out.println(doc);
		}
		return "redirect:/";
	}*/
	
	@GetMapping(value = "/load-products/{term}", produces = {"application/json"})
	public @ResponseBody List<Producto> loadProducts(@PathVariable("term") String texto) {
		return serviceProducto.buscarPorCodigoONombre(texto);
	}
	
	@ModelAttribute
	public void tiposDocumentos(Model model) {
		List<TipoDocumento> tipos = serviceTipoDocumento.buscarTodos();
		model.addAttribute("documentTypes", tipos);
	}
	
	@ModelAttribute
	public void clientes(Model model) {
		List<Cliente> clientes = serviceCliente.buscarTodos();
		model.addAttribute("clientes", clientes);
	}
	
	@ModelAttribute
	public void usuario(Model model) {
		List<Usuario> usuarios = serviceUsuario.buscarTodos();
		model.addAttribute("usuarios", usuarios);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
