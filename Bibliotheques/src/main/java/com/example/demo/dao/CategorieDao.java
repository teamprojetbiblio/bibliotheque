package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Categorie;

public interface CategorieDao extends JpaRepository<Categorie, Long>{
	@Query( "select c from Livre c where c.categorie.id_cat like %:x%" )
	public List <Categorie> getCategorie(@Param("x" )Long id);
	}
