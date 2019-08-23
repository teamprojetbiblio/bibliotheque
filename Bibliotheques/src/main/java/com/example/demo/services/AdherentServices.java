package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAdherentDao;
import com.example.demo.entities.Adherent;

@Service
@Transactional
public class AdherentServices {
	
	//injecter par dependance adherentDao
	@Autowired
	private IAdherentDao adherentDao;
	
	
	//methode affichage liste adherent
	public List<Adherent> getAllAdhe()
	{
		return adherentDao.findAll();
	}
	
	
	//methode recherche adherent par id
	public Adherent findAdherentById(long id)
	{
		return adherentDao.getOne(id);
	}
	
	//methode ajouter un adherent
	public Adherent addAdhrent(Adherent adh)
	{
		return adherentDao.save(adh);
	}
	
	//methode modifier un adherent
	public Adherent updateAdhrent(Adherent adh)
	{
		return adherentDao.save(adh);
	}
	
	//methode supprimer un adherent
	public void deleteAdherent(long id)
	{
		adherentDao.deleteById(id);
		return;
	}
	
	
	//methode recherche adherents par nom
	public List<Adherent> findAdherentByName(Adherent adh)
	{
		return adherentDao.rechParNom(adh.getNom());
	}
	
	//methode recherche adherents par ville
	public List<Adherent> findAdherentByVille(Adherent adh)
	{
		return adherentDao.rechParVille(adh.getVille());
	}
	

}
