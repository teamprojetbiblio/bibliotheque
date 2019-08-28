package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Administrateur;

public interface IAdminDao extends JpaRepository<Administrateur, Long> {
	
	
	//définir la méthode pour la connexion
	@Query("SELECT adm from Administrateur as adm where adm.email=:pEmail and adm.mdp=:pMdp")
	public Administrateur loginAdmin(@Param("pEmail") String email, @Param("pMdp") String mdp);

}
