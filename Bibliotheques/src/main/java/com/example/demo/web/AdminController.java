package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Administrateur;
import com.example.demo.services.AdminService;

@Controller
@RequestMapping("/admController")
@Scope("session")
public class AdminController {
	
	//injection de dépendance de l'adminService :
	@Autowired
	private AdminService adminService;	
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}



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
	
	
	
	////////Methode pour ajouter un administrateur :
			////Affichage du formulaire :
	@RequestMapping(value="/afficherAddAdmin", method = RequestMethod.GET)
	public ModelAndView afficherAddAdmin(Model modele)
	{
		//insérer un admin dans le modele:
		//modele.addAttribute("admAdd", new Administrateur());
		
		//retourner la page jsp :
		//return "ajoutAdmin";
		return new ModelAndView("ajoutAdmin","admAdd", new Administrateur());
	}
	
	////Soumettre le formulaire :
	@RequestMapping(value="/submitAddAdmin", method = RequestMethod.POST)
	public String submitAddAdmin(Model modele, @ModelAttribute("admAdd") Administrateur adm)
	{
		
		//appel de la fonction ajouter un admin :
		Administrateur admOut=adminService.addAdmin(adm);
		
		
		if(admOut != null)
		{
		//faire appel à la fonstion getAll pour mettre à jour la liste:
		List<Administrateur> listeAdmin=adminService.getAllAdmin();
		
		//mettre à jour la liste dans le modele :
		modele.addAttribute("listeAdmin", listeAdmin);
		
		//retourner à la jsp voulue :
		return "accueilAdmin";
		}
		else
		{
			return "ajoutAdmin";
		}
		
	}
	
	
	//supprimer un administrateur avec un lien
	@RequestMapping(value="/deleteLinkAdm/{pId}",method = RequestMethod.GET)
	public String deleteLinkAdm(Model modele, @PathVariable ("pId") long id)
	{
		//instancier un administrateur :
		Administrateur adminIn=new Administrateur();
		adminIn.setId_adm(id);
		
		//appel de la fonction supprimer :
		adminService.deleteAdmin(id);
		
		//appel de la fonction getAll pour remettre à jour la liste :
		List<Administrateur> listeAdmin= adminService.getAllAdmin();
		
		//remise à jour du modele :
		modele.addAttribute("listeAdmin", listeAdmin);
		
		//retourne à la JSP voulue :
		return "accueilAdmin";	
		
	}
	
	
	
	/////Methode pour rechercher un administrateur par son id:
	          ////Pour afficher le formulaire :
	@RequestMapping(value="/afficheRechAdm",method = RequestMethod.GET)
	public ModelAndView afficheRechAdm()
	{
		return new ModelAndView("rechAdmin","admRech", new Administrateur());
	}
	
	         /////Pour soumettre le formulaire :
	@RequestMapping(value="/submitRechAdm", method = RequestMethod.POST)
	public String submitRechAdm(Model modele, @ModelAttribute("admRech") Administrateur adm)
	{
		//appel de la fonction rechercher par l'id de l'administrateur:
		Administrateur admOut= adminService.findAdminById(adm.getId_adm());
		
		if(admOut != null)
		{
			modele.addAttribute("admFind", admOut);
			
			return "rechAdmin";
		}
		else
		{
			return "rechAdmin";
		}
	}
		
	
	////Methode pour modifier un administrateur :
                    ////Pour afficher le formulaire :
	@RequestMapping(value="/afficheUpdateAdm",method = RequestMethod.GET)
	public ModelAndView afficheUpdateAdm()
	{
		return new ModelAndView("modifAdmin","admMod", new Administrateur());
	}
	
	            ///Pour soumettre le formulaire :
	@RequestMapping(value="/submitUpdateAdm", method = RequestMethod.POST)
	public String submitUpdateAdm(Model modele, @ModelAttribute("admMod") Administrateur adm)
	{
		//appel dela fonction de modification d'un administrateur :
		Administrateur admOut=adminService.updateAdmin(adm);
		
		if(admOut != null)
		{
			//remise à jur de la liste :
			List<Administrateur> listeAdmin=adminService.getAllAdmin();
			
			//remise à jour du modele:
			modele.addAttribute("listeAdmin", listeAdmin);
			
			return "accueilAdmin";
		}
		else
		{
			return "modifAdmin";
		}
	}


	///Methode pour le lien de la modification :
	@RequestMapping(value="/updateLinkAdmin", method = RequestMethod.GET)
	public String updateLinkAdmin(Model modele,  @RequestParam ("pId") long id)
	{
		//instancier un administrateur :
		Administrateur admIn=new Administrateur();
		admIn.setId_adm(id);
		
		//appel à la fonction findById pour chercher un admin :
		Administrateur admOut= adminService.findAdminById(admIn.getId_adm());
		
		//mettre à jour le modele:
		modele.addAttribute("admMod", admOut);
		
		return "modifAdmin";
	}
	
	

}
