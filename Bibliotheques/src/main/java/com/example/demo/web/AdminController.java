package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Administrateur;
import com.example.demo.services.AdminService;

@Controller
@RequestMapping("/admController")
@Scope("session")
public class AdminController {
	
	//injection de dépendance de l'adminService :
	@Autowired
	private AdminService adminService;
	
	
	
	/////////Methode affichage de la liste des administrateurs :
	@RequestMapping(value="/listeAdmin",method = RequestMethod.GET)
	public String afficherListAdmin(Model modele)
	{
		
		//appel de la fonction getAll :
		List<Administrateur> listeAdmin= adminService.getAllAdmin();
		
		//stockage de la liste dans le modele  :
		modele.addAttribute("listeAdmin", listeAdmin);
		
		//retour sur la page JSP:
		return "accueilAdmin";
		}

}
