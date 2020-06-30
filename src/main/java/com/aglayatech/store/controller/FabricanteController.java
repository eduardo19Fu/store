package com.aglayatech.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.store.model.Fabricante;
import com.aglayatech.store.service.IFabricanteService;

@Controller
@RequestMapping(value = "/makers")
public class FabricanteController {
	
	@Autowired
	private IFabricanteService serviceFabricante;
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		List<Fabricante> makers = serviceFabricante.buscarTodos();
		model.addAttribute("makers", makers);
		return "pages/makers/list";
	}
	
	@GetMapping(value = "/create")
	public String create(Fabricante fabricante) {
		return "pages/makers/formMaker";
	}
	
	@PostMapping(value = "/save")
	public String save(Fabricante fabricante, RedirectAttributes attributes, BindingResult result) {
		
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "pages/makers/formMaker";
		}
		
		serviceFabricante.guardar(fabricante);
		attributes.addFlashAttribute("message", "Register was successfully made!");
		return "redirect:/makers/index";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") int idfabricante, Model model) {
		Fabricante maker = serviceFabricante.buscarPorId(idfabricante);
		model.addAttribute("fabricante", maker);
		return "pages/makers/formMaker";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") int idfabricante, RedirectAttributes attributes) {
		serviceFabricante.eliminar(idfabricante);
		attributes.addFlashAttribute("message", "Register was successfully deleted!");
		return "redirect:/makers/index";
	}
}
