package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Adherent;

public interface IAdherentDao extends JpaRepository<Adherent, Long> {
	
	@Query("SELECT adh FROM Adherent adh WHERE adh.nom like %:x%")
	public Page<Adherent> rechParNom(@Param("x") String mcN, Pageable pageable );
	
	@Query("SELECT adh FROM Adherent adh WHERE adh.ville like %:x%")
	public Page<Adherent> rechParVille(@Param("x") String mcN, Pageable pageable );
	
	public List<Adherent> retardAdherent();

}
