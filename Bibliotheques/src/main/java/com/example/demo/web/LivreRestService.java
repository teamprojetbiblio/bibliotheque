
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

import com.example.demo.dao.LivreDao;
import com.example.demo.entities.Livre;

@RestController
@CrossOrigin("*")
public class LivreRestService {

	@Autowired
	private LivreDao livreDao;

	@RequestMapping(value = "/livres", method = RequestMethod.GET)
	public List<Livre> getContact() {
		return livreDao.findAll();
	}

	@RequestMapping(value = "/livres/{id}", method = RequestMethod.GET)
	public Livre getLivres(@PathVariable Long id) {
		return livreDao.findById(id).get();
	}

	@RequestMapping(value = "/livresPages", method = RequestMethod.GET)
	public Page<Livre> chercher(

			@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Page<Livre> p = livreDao.chercher(mc, new PageRequest(page, size));
		return p;
	}

	@RequestMapping(value = "/saveLivre", method = RequestMethod.POST)
	public Livre save(@RequestBody Livre livre) {
		return livreDao.save(livre);

	}

	@RequestMapping(value = "/updatelivre", method = RequestMethod.PUT)
	public Livre UpdateLivre(@RequestBody Livre livre) {
		return livreDao.save(livre);

	}

	@RequestMapping(value = "/livre/{id}", method = RequestMethod.DELETE)
	public void DeleteContacts(@PathVariable Long id) {
		livreDao.deleteById(id);
		
	}
	@RequestMapping(value="/deleteLivre/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
         livreDao.deleteById(id);
         
    }
	
}
