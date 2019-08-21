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
	
	@Autowired
	private IAdherentDao adherentDao;
	
	
	public List<Adherent> getAllAdhe()
	{
		return adherentDao.findAll();
	}
	
	
	public Adherent findAdherentById(long id)
	{
		return adherentDao.findById(id).get();
	}
	
	public Adherent addAdhrent(Adherent adh)
	{
		return adherentDao.save(adh);
	}
	
	public Adherent updateAdhrent(Adherent adh)
	{
		return adherentDao.save(adh);
	}
	
	public void deleteAdherent(long id)
	{
		adherentDao.deleteById(id);
		return;
	}
	
	public List<Adherent> findAdherentByName(Adherent adh)
	{
		return adherentDao.rechParNom(adh.getNom());
	}
	
	public List<Adherent> findAdherentByVille(Adherent adh)
	{
		return adherentDao.rechParVille(adh.getVille());
	}
	

}
