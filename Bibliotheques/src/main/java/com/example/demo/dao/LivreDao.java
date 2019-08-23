package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Livre;

public interface LivreDao extends JpaRepository<Livre, Long>{
	@Query("select l from Livre l where l.titre like %:x%")
	public Page<Livre> chercher (@Param("x")String mc, Pageable pageable);
	
	public Livre findById(long id);
	}
