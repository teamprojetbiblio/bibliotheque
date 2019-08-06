package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categorie implements Serializable {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_cat;
	private String libelle;
	
	//association livre/categorie:
	@OneToMany(mappedBy="categorie",fetch=FetchType.LAZY)
	private List<Livre> listeLivre;
	
	//constructeurs
	public Categorie() {
		super();
	}
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	//getters et setters
	public long getId_cat() {
		return id_cat;
	}
	public void setId_cat(long id_cat) {
		this.id_cat = id_cat;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	public List<Livre> getListeLivre() {
		return listeLivre;
	}
	public void setListeLivre(List<Livre> listeLivre) {
		this.listeLivre = listeLivre;
	}
	//toString
	@Override
	public String toString() {
		return "Categorie [id_cat=" + id_cat + ", libelle=" + libelle + "]";
	}
	
	

}
