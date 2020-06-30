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

import com.aglayatech.store.model.Familia;
import com.aglayatech.store.service.IFamiliaService;

@Controller
@RequestMapping(value = "/families")
public class FamiliaController {
	
	@Autowired
	private IFamiliaService serviceFamilia;
	
	@GetMapping(value = "/index")
	public String familiasIndex(@ModelAttribute Familia familia, Model model, BindingResult result) {
		List<Familia> families = serviceFamilia.buscarTodos();
		model.addAttribute("families", families);
		return "pages/families/list";
	}
	
	@GetMapping(value = "/create")
	public String create(Familia familia) {
		return "pages/families/formFamily";
	}
	
	@PostMapping(value = "/save")
	public String save(Familia familia, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "pages/create/formFamily";
		}else {
			serviceFamilia.guardar(familia);
			attributes.addFlashAttribute("message", "Congratulations! Your register was successfully made!");
			return "redirect:/families/index";
		}
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") int idfamilia,Model model) {
		Familia family = serviceFamilia.buscarPorId(idfamilia);
		model.addAttribute("familia", family);
		return "pages/families/formFamily";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") int idfamilia, RedirectAttributes attributes) {
		serviceFamilia.eliminar(idfamilia);
		attributes.addFlashAttribute("message", "Register was successfully deleted!");
		return "redirect:/families/index";
	}

}
