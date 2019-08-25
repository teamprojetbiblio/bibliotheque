package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="adherents")
public class Adherent implements Serializable {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_adh;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String adresse;
	private String ville;
	private String telephone;
	
	//association adherents/emprunt
	@JsonIgnore
	@OneToMany(mappedBy="adherent",fetch=FetchType.LAZY, cascade=CascadeType.DETACH)
	private List<Emprunt> listeEmprunt;
	
	
	
	//constructeurs
	public Adherent() {
		super();
	}
	public Adherent(String nom, String prenom, String email, String password, String adresse, String ville,
			String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	
	
	public Adherent(long id_adh, String nom, String prenom, String email, String password, String adresse, String ville,
			String telephone) {
		super();
		this.id_adh = id_adh;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	
	//getters et setters
	public long getId_adh() {
		return id_adh;
	}
	public void setId_adh(long id_adh) {
		this.id_adh = id_adh;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public List<Emprunt> getListeEmprunt() {
		return listeEmprunt;
	}
	public void setListeEmprunt(List<Emprunt> listeEmprunt) {
		this.listeEmprunt = listeEmprunt;
	}
	//toString
	@Override
	public String toString() {
		return "Adherent [id_adh=" + id_adh + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", adresse=" + adresse + ", ville=" + ville + ", telephone=" + telephone + "]";
	}

	
	
}

