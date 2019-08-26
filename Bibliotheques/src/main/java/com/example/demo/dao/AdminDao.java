package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entities.Administrateur;

public class AdminDao implements IAdminDao {
	
	//injection de dépendance de l'entity manager :
	@PersistenceContext
	private EntityManager em;
	
	
	//injection de dépendance de AdminDao :
	@Autowired
	private IAdminDao adminDao;

	@Override
	public List<Administrateur> findAll() {
		// TODO Auto-generated method stub
		return adminDao.findAll();
	}

	@Override
	public List<Administrateur> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrateur> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return adminDao.findAllById(ids);
	}

	@Override
	public <S extends Administrateur> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Administrateur> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Administrateur> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrateur getOne(Long id) {
		// TODO Auto-generated method stub
		return adminDao.findById(id).get();
	}

	@Override
	public <S extends Administrateur> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrateur> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Administrateur> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrateur> S save(S entity) {
		// TODO Auto-generated method stub
		return adminDao.save(entity);
	}

	@Override
	public Optional<Administrateur> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		adminDao.deleteById(id);
		
	}

	@Override
	public void delete(Administrateur entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Administrateur> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Administrateur> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrateur> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Administrateur> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Administrateur> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
