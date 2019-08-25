package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IAdherentDao;
import com.example.demo.entities.Adherent;

@RestController
@CrossOrigin("*")
public class AdherentRestService {

	@Autowired
	private IAdherentDao adherentDao;
	
	
	//methode retourne liste complete adherent pour le front
	@RequestMapping(value = "/adherents", method =RequestMethod.GET)
	public List<Adherent> getAllAdherent()
	{
		return adherentDao.findAll();
	}
	
	
	//retourne adherent par l'id pour le front
	@RequestMapping(value = "/adherents/{id}", method = RequestMethod.GET)
	public Adherent getAdherentById(@PathVariable("id") long id)
	{
		return adherentDao.getOne(id);
	}
	
	
	//ajouter unn adherent (front)
	@RequestMapping(value = "/adherents",method = RequestMethod.POST)
	public Adherent addAdhrent(@RequestBody Adherent adh)
	{
		return adherentDao.save(adh);
	}
	
	//modifier un adherent (front)
	@RequestMapping(value = "/adherents/{pId}",method = RequestMethod.PUT)
	public Adherent updateAdhrent(@RequestBody Adherent adh, @PathVariable("pId")  long id)
	{
		return adherentDao.save(adh);
	}
	
	//supprimer un adherent (front)
	@RequestMapping(value="/adherents/{pId}",method = RequestMethod.DELETE)
	public void deleteContact(@PathVariable("pId") long id)
	{
		adherentDao.deleteById(id);
	}
	
	//rechercher un adherent par son nom (front)
	@RequestMapping(value = "/rechAdherentNom",method = RequestMethod.GET)
	public List<Adherent> rechercheAdherentNom(String nom)
	{
		List<Adherent> listAdhe=adherentDao.rechParNom(nom);
				return listAdhe;
	}
	
	//rechercher un adhérent par la ville (front)
	@RequestMapping(value = "/rechAdherentVille",method = RequestMethod.GET)
	public List<Adherent> rechercheAdherentVille(String ville)
	{
		List<Adherent> listAdhe=adherentDao.rechParVille(ville);
				return listAdhe;
	}
	
	@RequestMapping(value = "/chercherAdherent", method = RequestMethod.GET)
	public Adherent chercherAdherent(@RequestParam(name="email") String email,
			@RequestParam(name="psw")String psw) {
		return adherentDao.checkLog(email,psw);
	}
}
