package com.example.demo.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.example.demo.entities.Adherent;

@Repository
@Transactional
public class AdherentDao implements IAdherentDao  {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	IAdherentDao adherentDao;

	//methode de l'affichage complete de la liste
	@Override
	public List<Adherent> findAll() {
		return adherentDao.findAll();
	}

	@Override
	public List<Adherent> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Adherent> findAllById(Iterable<Long> ids) {
		return adherentDao.findAllById(ids);
	}

	@Override
	public <S extends Adherent> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Adherent> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Adherent> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	
	//methode rechercher un adherent par l'id
	@Override
	public Adherent getOne(Long id) {
		return  adherentDao.findById(id).get();
	}

	@Override
	public <S extends Adherent> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Adherent> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Adherent> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	//ajouter/modifier les champs d'un adherent
	@Override
	public <S extends Adherent> S save(S entity) {
		
		//em.persist(entity);
		
		//return entity;
		return adherentDao.save(entity);
	}



	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	//supprimer un adherent de la liste
	@Override
	public void deleteById(Long id) {	
		adherentDao.deleteById(id);	
	}

	@Override
	public void delete(Adherent entity) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void deleteAll(Iterable<? extends Adherent> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {		
		for (Adherent adh : findAll()) {
			delete(adh);
		}
	}

	@Override
	public <S extends Adherent> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Adherent> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Adherent> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Adherent> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Adherent> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	

	@Override
	public List<Adherent> rechParNom(String mcN) {
		// TODO Auto-generated method stub
		return adherentDao.rechParNom(mcN);
	}

	@Override
	public List<Adherent> rechParVille(String mcN) {
		// TODO Auto-generated method stub
		return adherentDao.rechParVille(mcN);
	}

	

	
	

	



}
