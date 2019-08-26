package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrateurs")
public class Administrateur implements Serializable {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_adm;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	
	//constructeurs:
	public Administrateur() {
		super();
	}
	public Administrateur(String nom, String prenom, String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}
	
	public Administrateur(long id_adm, String nom, String prenom, String email, String mdp) {
		super();
		this.id_adm = id_adm;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}
	
	
	//getters et setters
	public long getId_adm() {
		return id_adm;
	}
	public void setId_adm(long id_adm) {
		this.id_adm = id_adm;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	//toString
	@Override
	public String toString() {
		return "Administrateur [id_ad=" + id_adm + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp="
				+ mdp + "]";
	}	

}
