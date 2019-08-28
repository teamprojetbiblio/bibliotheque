package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.example.demo.dao.IAdherentDao;
import com.example.demo.entities.Adherent;
import com.example.demo.entities.Administrateur;
import com.example.demo.entities.Emprunt;
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
	
	
	//injection de dépendance du service adherent
	@Autowired
	private AdherentServices adherentService;

	public void setAdherentService(AdherentServices adherentService) {
		this.adherentService = adherentService;
	}


	/////affichage de la liste
	@RequestMapping(value="/listeAdherent", method=RequestMethod.GET)
	public String afficherListAdherent(Model modele, HttpSession session, @ModelAttribute("admLog") Administrateur adminIn)
	{
		
		if(session.getAttribute("adminIn")!=null)
		{
		//appel de la fonction getAll
		List<Adherent> listeAdhe=adherentService.getAllAdhe();
		
		modele.addAttribute("listeAdherent", listeAdhe);
		
		modele.addAttribute("adhAjout", new Adherent());
		
		//retour d'un modele and view composé de la jsp et stockage de la liste dans le modele
		return "accueilAdherent";
		}
		else
		{
			return "redirect:/admController/login";
		}
		
	}
	
	
	/////ajout dans la liste
			//afficher le formulaire
	@RequestMapping(value="/addAdhAffiche", method = RequestMethod.GET)
	public  String addAdhAffiche(Model modele, HttpSession session, @ModelAttribute("admLog") Administrateur adminIn)
	{
	
		if(session.getAttribute("adminIn")!=null)
		{
		modele.addAttribute("adhAjout",new Adherent());
		
		return "ajoutAdherent";
		}
		else
		{
			return "redirect:/admController/login";
		}
	}
	
			//soumettre le formulaire
	@RequestMapping(value="/addAdhSubmit",method = RequestMethod.POST)
	public  String addAdhSubmit(Model modele, @ModelAttribute("adhAjout") Adherent adherent)
	{
		//appel de la fonction ajouter adherent
		Adherent adhOut=adherentService.addAdhrent(adherent);
		
		if(adhOut!=null)
		{
			//appel de la fonction getAll
			List<Adherent> listeAdh=adherentService.getAllAdhe();
			
			//mettre à jour la liste dans le modele
			modele.addAttribute("listeAdherent",listeAdh );
			
			
			//retour sur la jsp voulue
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
	public String rechercherAdhIdAffiche(Model modele, HttpSession session, @ModelAttribute("admLog") Administrateur adminIn)
	{		
		if(session.getAttribute("adminIn")!=null)
		{
		modele.addAttribute("adhRech",new Adherent());		
		//retour d'un modele and view composé de la jsp et stockage de la liste dans le modele
		return "rechercheId";
		}
		else
		{
			return "redirect:/admController/login";
		}
	}
	
	@RequestMapping(value = "/rechercherAdhIdSubmit",method = RequestMethod.POST)
	public String rechercherAdhIdSubmit(Model modele, @ModelAttribute("adhRech") Adherent adhrent)
	{
		//appel de la fonction rechercher Id adherent
		Adherent adhOut=adherentService.findAdherentById(adhrent.getId_adh());
		
		if(adhOut!=null)
		{
			//mettre le résultat de la recherche dans le modele
			modele.addAttribute("adhFind", adhOut);
			
			//retour sur la jsp voulue
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
public String updateAdhAffiche(Model modele,HttpSession session, @ModelAttribute("admLog") Administrateur adminIn)
{
	if(session.getAttribute("adminIn")!=null)
	{
	//retour d'un modele and view composé de la jsp et stockage de la liste dans le modele
	modele.addAttribute("adhModif",new Adherent());	
	return "modifAdherent";
	}
	else
	{
		return "redirect:/admController/login";
	}
	
}

	//soumettre le formulaire
@RequestMapping(value="/updateAdhSubmit",method = RequestMethod.POST)
public String updateAdhSubmit(Model modele, @ModelAttribute("adhModif") Adherent adherent)
{
	//appel de la fonction modifier adherent
Adherent adhOut=adherentService.updateAdhrent(adherent);

if(adhOut!=null)
{
	//appel de la fonction getAll
	List<Adherent> listeAdh=adherentService.getAllAdhe();
	
	//mettre la liste à jour dans le modele
	modele.addAttribute("listeAdherent",listeAdh );
	modele.addAttribute("adhAjout", new Adherent());
	
	//retour sur la jsp voulue
	return "accueilAdherent";
}
else
{
	return "modifAdherent";
}

}


////////lien de modification :
@RequestMapping(value="/updateLinkAdh",method = RequestMethod.GET)
public String updateLinkAdh(Model modele, @RequestParam("pId") long id, HttpSession session, @ModelAttribute("admLog") Administrateur adminIn)
{
	if(session.getAttribute("adminIn")!=null)
	{
	//instantiation d'un adherent
	Adherent adhIn=new Adherent();
	//mettre comme attribut id de l'adherent l'id request param
	adhIn.setId_adh(id);
	
	//appel de la fonction findById
	Adherent adhOut=adherentService.findAdherentById(adhIn.getId_adh());
	
	//mettre le resultat de la recherche dans le modele
	modele.addAttribute("adhModif",adhOut);
	
	//retour à la jsp voulue
	return "modifAdherent"; 
	}
	else
	{
		return "redirect:/admController/login";
	}
}




//////lien de suppression :
@RequestMapping(value = "/deleteLinkAdh/{pId}",method = RequestMethod.GET)
public String deleteLinkAdh(Model modele, @PathVariable ("pId") long id,HttpSession session, @ModelAttribute("admLog") Administrateur adminIn)
{
	
	if(session.getAttribute("adminIn")!=null)
	{
	//instantiation d'un adherent
	Adherent adhIn=new Adherent();
	//mettre comme attribut id de l'adherent l'id request param
	adhIn.setId_adh(id);
	
	//appel de la methode supprimer adherent
	adherentService.deleteAdherent(adhIn.getId_adh());
	
	//appel de la fonction getAll
	List<Adherent> listeAdh=adherentService.getAllAdhe();
	
	//mettre la liste a jour dans le modele
	modele.addAttribute("listeAdherent",listeAdh);
	
	modele.addAttribute("adhAjout", new Adherent());

	
	//retour a la jsp voulue
	return "accueilAdherent";
	}
	else
	{
		return "redirect:/admController/login";
	}
	
}



///////////rechercher l'adhérent par le nom
//afficher le formulaire
@RequestMapping(value="/rechercherAdhNomAffiche",method = RequestMethod.GET)
public ModelAndView rechercherAdhNomAffiche()
{		
//retour d'un modele and view composé de la jsp et stockage de la liste dans le modele
return new ModelAndView("rechercheNom","adhRechNom",new Adherent());
}

@RequestMapping(value = "/rechercherAdhNomSubmit",method = RequestMethod.POST)
public String rechercherAdhNomSubmit(Model modele, @ModelAttribute("adhRechNom") Adherent adhrent)
{
//appel de la fonction rechercher Id adherent
List<Adherent> listeNom=adherentService.findAdherentByName(adhrent);

if(listeNom!=null)
{
	//mettre le résultat de la recherche dans le modele
	modele.addAttribute("listeNom", listeNom);
	
	//retour sur la jsp voulue
	return "rechercheNom";
}
else
{
	return "rechercheNom";
}
}


///////////rechercher l'adhérent par le ville
//afficher le formulaire
@RequestMapping(value="/rechercherAdhVilleAffiche",method = RequestMethod.GET)
public ModelAndView rechercherAdhVilleAffiche()
{		
//retour d'un modele and view composé de la jsp et stockage de la liste dans le modele
return new ModelAndView("rechercheVille","adhRechVille",new Adherent());
}

@RequestMapping(value = "/rechercherAdhVilleSubmit",method = RequestMethod.POST)
public String rechercherAdhVilleSubmit(Model modele, @ModelAttribute("adhRechVille") Adherent adhrent)
{
//appel de la fonction rechercher Id adherent
List<Adherent> listeVille=adherentService.findAdherentByVille(adhrent);

if(listeVille!=null)
{
//mettre le résultat de la recherche dans le modele
modele.addAttribute("listeVille", listeVille);

//retour sur la jsp voulue
return "rechercheVille";
}
else
{
return "rechercheVille";
}
}



	

}
