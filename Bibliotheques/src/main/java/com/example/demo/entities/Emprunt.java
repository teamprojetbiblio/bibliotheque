package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emprunts")
public class Emprunt implements Serializable {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_emp;
	@Column(name="date_emprunt")
	@Temporal(TemporalType.DATE)
	private Date dateEmprunt;
	@Column(name="date_retour")
	@Temporal(TemporalType.DATE)
	private Date dateRetour;
	
	//association adherents/emprunt
	@ManyToOne
	@JoinColumn(name="adh_id",referencedColumnName="id_adh")
	private Adherent adherent;
	
	
	//association emprunt/exemplaire:
	@ManyToOne
	@JoinColumn(name="exe_id", referencedColumnName="id_exe")
    private Exemplaire exemplaire;
	
	//constructeurs
	public Emprunt() {
		super();
	}
	public Emprunt(Date dateEmprunt, Date dateRetour) {
		super();
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
	}
	
	//getters et setters
	public long getId_emp() {
		return id_emp;
	}
	public void setId_emp(long id_emp) {
		this.id_emp = id_emp;
	}
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	
	
	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	//toString
	@Override
	public String toString() {
		return "Emprunt [id_emp=" + id_emp + ", dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour + "]";
	}
	
	
	

}
