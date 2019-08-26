package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpruntDao;
import com.example.demo.entities.Emprunt;
import com.example.demo.entities.Livre;

@RestController
@CrossOrigin("*")
public class EmpruntRestService {
	@Autowired
	private EmpruntDao empruntDao;
	
	@RequestMapping(value = "/listeEmprunts", method = RequestMethod.GET)
	public List<Emprunt>getEmprunts(){
		return empruntDao.findAll();
	}
	@RequestMapping(value = "/listeEmprunts/{id}", method = RequestMethod.GET)
	public Emprunt getEmprunt(@PathVariable Long id) {
		return empruntDao.findById(id).get();
	}
	@RequestMapping(value = "/empruntsPages", method = RequestMethod.GET)
	public Page<Emprunt> chercher(

			@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Page<Emprunt> p = empruntDao.chercher(mc, PageRequest.of(page, size));
		return p;
	}
//	@RequestMapping(value = "/chercherEmprunts", method = RequestMethod.GET)
//	public Page<Emprunt> chercher(@RequestParam(name="mc",defaultValue="") long mc,
//			@RequestParam(name="page",defaultValue="0")int page,
//			@RequestParam(name="size",defaultValue="5")int size) {
//		return empruntDao.chercher(mc,PageRequest.of(page, size));
//	}
	
}
