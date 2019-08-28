package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAdminDao;
import com.example.demo.entities.Administrateur;

@Service
@Transactional
public class AdminService {
	
	//injecter par dépendance adminDao :
	@Autowired
	private IAdminDao adminDao;
	
	
	//methode affichage de la liste :
	public List<Administrateur> getAllAdmin()
	{
		return adminDao.findAll();
	}
	
	
	//methode find admin par l'id :
	public Administrateur findAdminById(long id)
	{
		return adminDao.getOne(id);	
	}
	
	//methode ajout un administrateur :
	public Administrateur addAdmin(Administrateur adm)
	{
		return adminDao.save(adm);
	}
	
	//methde modifier les éléments d'un administrateur :
	public Administrateur updateAdmin (Administrateur adm)
	{
		return adminDao.save(adm);
	}

	//méthode suppression de la base d'un admin :
	public void deleteAdmin(long id)
	{
		adminDao.deleteById(id);
		return ;
	}
	
	
	//methode ppour la connexion:
	public Administrateur loginAdmin(String email,String mdp)
	{
		return adminDao.loginAdmin(email, mdp);
	}
	
}
