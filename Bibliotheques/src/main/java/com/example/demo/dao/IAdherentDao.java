package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Adherent;
import com.example.demo.entities.Emprunt;

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
	
	
	/*@Query("select adh.id_adh AS num_adherent, adh.nom, adh.prenom, ex.id_exe AS num_exemplaire, li.id_liv AS num_livre, "
			+ " li.titre,em.id_emp AS num_emprunt"
			+ " FROM Adherent AS adh INNER JOIN Emprunt AS em ON adh.id_adh=em.adherent.id_adh"
			+ " INNER JOIN Exemplaire AS ex ON ex.id_exe=em.exemplaire.id_exe"
			+ " INNER JOIN Livre AS li ON li.id_liv=ex.livre.id_liv"
			+ " WHERE DATEDIFF(current_date,em.dateEmprunt)>21")
	public List<Emprunt> getLatecomer();*/
	

}
