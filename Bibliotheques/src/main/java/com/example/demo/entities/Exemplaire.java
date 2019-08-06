package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="exemplaires")
public class Exemplaire {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_exe;
	private String etat;
	
	//association emprunt/exemplaire:
	@OneToMany(mappedBy="exemplaire",fetch=FetchType.LAZY)
	private List<Emprunt> listeEmprunt;
	
	//association livre exemplaire :
	@ManyToOne
	@JoinColumn(name="liv_id",referencedColumnName="id_liv")
	private Livre livre;
	
	
	//constructeurs
	public Exemplaire() {
		super();
	}
	public Exemplaire(String etat) {
		super();
		this.etat = etat;
	}
	
	//getters et setters
	public long getId_exe() {
		return id_exe;
	}
	public void setId_exe(long id_exe) {
		this.id_exe = id_exe;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
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
		return "Exemplaire [id_exe=" + id_exe + ", etat=" + etat + "]";
	}
	
	

}
