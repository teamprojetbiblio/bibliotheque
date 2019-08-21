package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.IAdherentDao;
import com.example.demo.entities.Adherent;

@Controller
@RequestMapping("/adhController")
@Scope("session")
public class AdherentController {
	
	@Autowired
	private IAdherentDao adherentDao;

	public void setAdherentDao(IAdherentDao adherentDao) {
		this.adherentDao = adherentDao;
	}
	
	
	/*@RequestMapping(value = {"/","/indexAdherent"},method = RequestMethod.GET)
	public String index (Model model)
	{
		String message="Hello word+jsp";
		model.addAttribute("message", message);
		return "indexAdherent";
	}*/

	
	@RequestMapping(value="/listeAdherent", method=RequestMethod.GET)
	public ModelAndView afficherListAdherent()
	{
		List<Adherent> listeAdhe=adherentDao.findAll();
		
		return new ModelAndView("accueilAdherent","listeAdherent",listeAdhe);
	}
	

}
