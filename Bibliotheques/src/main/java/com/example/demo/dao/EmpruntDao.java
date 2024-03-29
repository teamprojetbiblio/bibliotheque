package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Adherent;
import com.example.demo.entities.Emprunt;


public interface EmpruntDao extends JpaRepository<Emprunt, Long> {
	@Query("select e from Emprunt e where e.adherent.id_adh like %:x%")
	public Page<Emprunt> chercher (@Param("x")String mc, Pageable pageable);
	
	@Query("select e from Emprunt e where e.adherent.nom like %:x%")
	public List<Emprunt> chercherParAdh (@Param("x")String mc);
	
	@Query("select e from Emprunt e where str(e.id_emp) like %:x%")
	public List<Emprunt> chercherParIdEmp (@Param("x")String mc);
	
	@Query("select e from Emprunt e where str(e.adherent.id_adh) like %:x%")
	public List<Emprunt> chercherParIdAdh (@Param("x")String mc);
	
	@Query("select e from Emprunt e where str(e.exemplaire.id) like %:x%")
	public List<Emprunt> chercherParIdExemp (@Param("x")String mc);
	
	@Query("select e from Emprunt e where e.exemplaire.livre.titre like %:x%")
	public List<Emprunt> chercherParLivre (@Param("x")String mc);
	
	@Query("select e from Emprunt e where str(e.dateEmprunt) like %:x%")
	public List<Emprunt> chercherParDateEmp (@Param("x")String mc);
	
	
	@Query("select e from Emprunt e where e.adherent.id_adh =:x")
	public List<Emprunt> chercherParSession (@Param("x")long adhId);
	
	/*@Query("select em.id_emp, em.adherent.id_adh, em.adherent.nom, em.adherent.prenom, "
			+ " em.exemplaire.id_exe, em.exemplaire.livre.id_liv, "
			+ " em.exemplaire.livre.titre FROM Emprunt AS em  WHERE DATEDIFF(current_date,em.dateEmprunt)>21")*/
	@Query("select em from Emprunt as em where DATEDIFF(current_date,em.dateEmprunt)>21 or DATEDIFF(em.dateRetour,em.dateEmprunt)>21   ")
	public List<Emprunt> getLatecomer();
	
	}


