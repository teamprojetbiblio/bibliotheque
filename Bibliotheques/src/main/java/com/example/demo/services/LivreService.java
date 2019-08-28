package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.LivreDao;
import com.example.demo.entities.Livre;

@Service
@Transactional
public class LivreService {
	private LivreDao livre_dao;

	public LivreService(LivreDao livre_dao) {
		this.livre_dao = livre_dao;
	}
public List<Livre>showAllLivres(){
		
		List<Livre> livres=new ArrayList<Livre>();
		
		for(Livre livre: livre_dao.findAll()) {
			livres.add(livre);
//			System.out.println(person.getEmail());
		}
		
		return livres;
		
		
	}

public void saveMyLivre(Livre livre) {
	
	livre_dao.save(livre);
}



//public void deleteMyLivre(int id) {
//	
//	livre_dao.deleteById(id);
	
//}
//public Livre editLivre(int id) {
//	
//	return livre_dao.findById(id);
//	
//}
//public Object findByEmailAndMotdepasse(String email, String motdepasse) {
//	// TODO Auto-generated method stub
//	return personRepository.findByEmailAndMotdepasse(email,motdepasse);
//}
}


