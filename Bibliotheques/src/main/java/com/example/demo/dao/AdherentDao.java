package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Adherent;

public class AdherentDao {
	
	//attribut de connexion
	private static final String URL="jdbc:mysql://localhost:3306/db_bibliotheques?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static final String USER="root";
	private static final String MDP="root";
	
	
	//methoodes :
	
public List<Adherent> getAllAdherents()
{
	try {
		//chargement du driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//creation de la connexion:
		Connection cx=DriverManager.getConnection(URL, USER, MDP);
		
		//requete sql :
		String req="SELECT * FROM adherents";
		
		//creation du statement :
		PreparedStatement ps= cx.prepareStatement(req);
		
		//creation du resultSet:
		ResultSet rs=ps.executeQuery();
		
		//creation de la liste de retour :
		List<Adherent> listeAdhe=new ArrayList<Adherent>();
		
		//retourner le resultat de la requete:
		while(rs.next())
		{
			//stockage des attributs de adherents 
			long idOut=rs.getLong("id_adh");
			String nomOut=rs.getString("nom");
			String prenomOut=rs.getString("prenomOut");
			String emailOut=rs.getString("email");
			String passwordOut=rs.getString("password");
			String adresseOut=rs.getString("adresse");
			String villeOut=rs.getString("ville");
			String telephoneOut=rs.getString("telephone");
			
			//creation de l'adherent à ajouter à la liste:
			Adherent adhOut=new Adherent(idOut, nomOut, prenomOut, emailOut, passwordOut, adresseOut, villeOut, telephoneOut);
			
			//ajouter adherent a la liste:
			listeAdhe.add(adhOut);
			
		}
		
		//retourner la liste :
		return listeAdhe;
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}

}
