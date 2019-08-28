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
@Table(name = "livres")
public class Livre implements Serializable {

	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_liv;
	private String titre;
	private String auteur;
	private String editeur;
	public Livre(String titre, String auteur, String editeur, String imgLivre, String description,
			List<Exemplaire> listeExemplaire, Categorie categorie) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.imgLivre = imgLivre;
		this.description = description;
		this.listeExemplaire = listeExemplaire;
		this.categorie = categorie;
	}

	private String imgLivre;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// association livre/exemplaire:
	@JsonIgnore
	@OneToMany(mappedBy = "livre", fetch = FetchType.LAZY)

	private List<Exemplaire> listeExemplaire;

	// association categorie/livre:
	@ManyToOne
	@JoinColumn(name = "cat_id", referencedColumnName = "id_cat")
	private Categorie categorie;

	// constructeurs
	public Livre() {
	}

	public Livre(String titre, String auteur, String editeur) {

		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
	}

	public Livre(String titre, String auteur, String editeur, String imgLivre, String description) {
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.imgLivre = imgLivre;
		this.description = description;

	}

	// getters et setters
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

	public String getImgLivre() {
		return imgLivre;
	}

	public void setImgLivre(String imgLivre) {
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

	// toString
	@Override
	public String toString() {
		return "Livre [id_liv=" + id_liv + ", titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur
				+ ", imgLivre=" + imgLivre + "]";
	}
}
