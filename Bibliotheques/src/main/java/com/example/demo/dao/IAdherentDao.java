package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Adherent;

public interface IAdherentDao extends JpaRepository<Adherent, Long> {
	
	//methode pour rechercher adherents par nom
	@Query("SELECT adh FROM Adherent adh WHERE adh.nom=:x")
	public List<Adherent> rechParNom(@Param("x") String mcN );
	
	//methode pour rechercher adherents par ville
	@Query("SELECT adh FROM Adherent adh WHERE adh.ville=:x")
	public List<Adherent> rechParVille(@Param("x") String mcV );
	
	//Vérification connexion adhérent (mail+password)
	@Query("select a FROM Adherent a where a.email=:x and a.password=:y")
	public Adherent checkLog(@Param("x") String email, @Param("y") String psw);
	

}
