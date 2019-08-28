package com.example.demo.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.CategorieDao;
import com.example.demo.dao.LivreDao;
import com.example.demo.entities.Categorie;

import com.example.demo.entities.Livre;
import com.example.demo.services.LivreService;



@Controller

public class LivreController {
		
	@Autowired
	private CategorieDao categorie_dao;

	@Autowired 
	LivreDao livre_dao;

	@Autowired 
	LivreService livre_service;

	
	@RequestMapping(value = { "/livres" }, method = RequestMethod.GET)
	public String viewLivre(Model model) {
		List<Livre> livres = livre_dao.findAll();
		
		//System.err.println(livres);
		List<Categorie> categories= categorie_dao.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("livres", livres);
		return "livre";

	}
	
	

	@RequestMapping(value = { "/cherchelivres" }, method = RequestMethod.GET)
	public Page<Livre> chercher(

			@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Page<Livre> p = livre_dao.chercher(mc, new PageRequest(page, size));
		return p;
	}
	
	@PostMapping(value = { "/saveMyLivres" })
	public String SauvegarderLivre(@ModelAttribute Livre livre, Model model) {
		livre_service.saveMyLivre(livre);
		List<Livre> livres = livre_dao.findAll();

		List<Categorie> categories= categorie_dao.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("livres", livres);
		
		return "/livre";
	}
}
