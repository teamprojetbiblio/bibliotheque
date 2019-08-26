
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

import com.example.demo.dao.CategorieDao;
import com.example.demo.dao.LivreDao;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Livre;

@RestController
@CrossOrigin("*")
public class LivreRestService {

	@Autowired
	private LivreDao livre_dao;
	
	@Autowired
	private CategorieDao categorie_dao;

	@RequestMapping(value = "/livres", method = RequestMethod.GET)
	public List<Livre> getLivres() {
		return livre_dao.findAll();
	}

	@RequestMapping(value = "/livres/{id}", method = RequestMethod.GET)
	public Livre getLivres(@PathVariable Long id) {
		return livre_dao.findById(id).get();
	}

	@RequestMapping(value = "/livresPages", method = RequestMethod.GET)
	public Page<Livre> chercher(

			@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Page<Livre> p = livre_dao.chercher(mc, PageRequest.of(page, size));
		return p;
	}

	@RequestMapping(value = "/saveLivre", method = RequestMethod.POST)
	public Livre save(@RequestBody Livre livre) {
		return livre_dao.save(livre);

	}

	@RequestMapping(value = "/updatelivre", method = RequestMethod.PUT)
	public Livre UpdateLivre(@RequestBody Livre livre) {
		return livre_dao.save(livre);

	}

	@RequestMapping(value = "/livre/{id}", method = RequestMethod.DELETE)
	public void Deletelivre(@PathVariable Long id) {
		livre_dao.deleteById(id);

	}

	@RequestMapping(value = "/deleteLivre/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		livre_dao.deleteById(id);

	}
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public List<Categorie> getCategories() {
		return categorie_dao.findAll();
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public List<Categorie> byCategories(@PathVariable Long id) {
		return categorie_dao.getCategorie(id);
	}
}
