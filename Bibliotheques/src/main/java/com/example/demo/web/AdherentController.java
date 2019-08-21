package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.IAdherentDao;
import com.example.demo.entities.Adherent;
import com.example.demo.services.AdherentServices;

@Controller
@RequestMapping("/adhController")
@Scope("session")
public class AdherentController {
	
	@Autowired
	private IAdherentDao adherentDao;

	public void setAdherentDao(IAdherentDao adherentDao) {
		this.adherentDao = adherentDao;
	}
	
	
	@Autowired
	private AdherentServices adherentService;
	
	
	/*@RequestMapping(value = {"/","/indexAdherent"},method = RequestMethod.GET)
	public String index (Model model)
	{
		String message="Hello word+jsp";
		model.addAttribute("message", message);
		return "indexAdherent";
	}*/

	public void setAdherentService(AdherentServices adherentService) {
		this.adherentService = adherentService;
	}


	/////affichage de la liste
	@RequestMapping(value="/listeAdherent", method=RequestMethod.GET)
	public ModelAndView afficherListAdherent()
	{
		List<Adherent> listeAdhe=adherentService.getAllAdhe();
		
		return new ModelAndView("accueilAdherent","listeAdherent",listeAdhe);
	}
	
	
	/////ajout dans la liste
			//afficher le formulaire
	@RequestMapping(value="/addAdhAffiche", method = RequestMethod.GET)
	public  ModelAndView addAdhAffiche()
	{
		return new ModelAndView("ajoutAdherent","adhAjout",new Adherent());
	}
	
			//soumettre le formulaire
	@RequestMapping(value="/addAdhSubmit",method = RequestMethod.POST)
	public  String addAdhSubmit(Model modele, @ModelAttribute("adhAjout") Adherent adherent)
	{
		Adherent adhOut=adherentService.addAdhrent(adherent);
		if(adhOut!=null)
		{
			List<Adherent> listeAdh=adherentService.getAllAdhe();
			modele.addAttribute("listeAdherent",listeAdh );
			return "accueilAdherent";
		}
		else
		{
			return "ajoutAdherent";
		}
		
	}
	
	
	 //////////rechercher par l'id:
			//afficher le formulaire
	@RequestMapping(value="/rechercherAdhIdAffiche",method = RequestMethod.GET)
	public ModelAndView rechercherAdhIdAffiche()
	{
		return new ModelAndView("rechercheId","adhRech",new Adherent());
	}
	
	@RequestMapping(value = "/rechercherAdhIdSubmit",method = RequestMethod.POST)
	public String rechercherAdhIdSubmit(Model modele, @ModelAttribute("adhRech") Adherent adhrent)
	{
		Adherent adhOut=adherentService.findAdherentById(adhrent.getId_adh());
		
		if(adhOut!=null)
		{
			modele.addAttribute("adhFind", adhOut);
			return "rechercheId";
		}
		else
		{
			return "rechercheId";
		}
	}
	
	
	/////modifier dans la liste
	//afficher le formulaire
@RequestMapping(value="/updateAdhAffiche", method = RequestMethod.GET)
public ModelAndView updateAdhAffiche()
{
return new ModelAndView("modifAdherent","adhModif",new Adherent());
}

	//soumettre le formulaire
@RequestMapping(value="/updateAdhSubmit",method = RequestMethod.POST)
public String updateAdhSubmit(Model modele, @ModelAttribute("adhModif") Adherent adherent)
{
Adherent adhOut=adherentService.updateAdhrent(adherent);
if(adhOut!=null)
{
	List<Adherent> listeAdh=adherentService.getAllAdhe();
	modele.addAttribute("listeAdherent",listeAdh );
	return "accueilAdherent";
}
else
{
	return "modifAdherent";
}

}



	

}
