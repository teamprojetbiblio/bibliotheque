package com.example.demo.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.EmpruntDao;
import com.example.demo.entities.Adherent;
import com.example.demo.entities.Emprunt;
import com.example.demo.entities.Exemplaire;
import com.example.demo.entities.Livre;


@Controller
@RequestMapping(value="/emprunts")
public class EmpruntsController {

	@Autowired
	private EmpruntDao empruntDao;
	
	SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
	
	///affichage de la liste
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model, @RequestParam(name = "filtre",defaultValue = "tesst") String filtre,
			@RequestParam(name = "mc", defaultValue = "") String mc){
		
		List<Emprunt> listeEmprunts;
		model.addAttribute("filtre", filtre);
		model.addAttribute("mc", mc);
		
		if(filtre.equals("all")) {
			listeEmprunts=empruntDao.findAll();
			model.addAttribute("listeEmprunts", listeEmprunts);
			
		}else if(filtre.equals("idEmp")) {
			listeEmprunts=empruntDao.chercherParIdEmp(mc);
			model.addAttribute("listeEmprunts", listeEmprunts);
			
		}else if(filtre.equals("idAdh")) {
			listeEmprunts=empruntDao.chercherParIdAdh(mc);
			model.addAttribute("listeEmprunts", listeEmprunts);
			
		}else if(filtre.equals("nomAdh")) {
			listeEmprunts=empruntDao.chercherParAdh(mc);
			model.addAttribute("listeEmprunts", listeEmprunts);
			
		}else if(filtre.equals("titreLiv")) {
			listeEmprunts=empruntDao.chercherParLivre(mc);
			model.addAttribute("listeEmprunts", listeEmprunts);
			
		}else if(filtre.equals("idExem")) {
			listeEmprunts=empruntDao.chercherParIdExemp(mc);
			model.addAttribute("listeEmprunts", listeEmprunts);
			
		}else if(filtre.equals("dateEmp")) {
			listeEmprunts=empruntDao.chercherParDateEmp(mc);
			model.addAttribute("listeEmprunts", listeEmprunts);
			
		}
		
		return "listeEmprunts";
	}
	
	
	
	@RequestMapping(value="/listeRetard",method = RequestMethod.GET)
	public String listeRetard(Model modele,HttpServletRequest request) throws ParseException
	{
		List<Emprunt> listeRetardataire=empruntDao.getLatecomer();

	    modele.addAttribute("listeRetardataire", listeRetardataire);
	    
	    return "listeRetardataire";
		
	}


		
	
}
