package com.example.demo.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="livres")
public class Livre implements Serializable {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_liv;
	private String titre;
	private String auteur;
	private String editeur;
	@Lob
	private byte [] imgLivre;
	
	//association livre/exemplaire:
	@JsonIgnore
	@OneToMany(mappedBy="livre",fetch=FetchType.LAZY)
	private List<Exemplaire> listeExemplaire;
	
	//association categorie/livre:
	@ManyToOne
	@JoinColumn(name="cat_id" , referencedColumnName="id_cat")
	private Categorie categorie;
	
	//constructeurs
	public Livre() {
		super();
	}


	public Livre(String titre, String auteur, String editeur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
	}


	public Livre(String titre, String auteur, String editeur, byte[] imgLivre) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.imgLivre = imgLivre;
	}


	//getters et setters
	public long getId_liv() {
		return id_liv;
	}


	public void setId_liv(long id_liv) {
		this.id_liv = id_liv;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getEditeur() {
		return editeur;
	}


	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}


	public byte[] getImgLivre() {
		return imgLivre;
	}


	public void setImgLivre(byte[] imgLivre) {
		this.imgLivre = imgLivre;
	}


	
	public List<Exemplaire> getListeExemplaire() {
		return listeExemplaire;
	}


	public void setListeExemplaire(List<Exemplaire> listeExemplaire) {
		this.listeExemplaire = listeExemplaire;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	//toString
	@Override
	public String toString() {
		return "Livre [id_liv=" + id_liv + ", titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur
				+ ", imgLivre=" + Arrays.toString(imgLivre) + "]";
	}
	
	
	
	
	
	

}
