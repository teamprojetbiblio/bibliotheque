package com.example.demo.servlet;

import javax.servlet.annotation.WebServlet;

import com.example.demo.dao.AdherentDao;
import com.example.demo.dao.IAdherentDao;

@WebServlet("/adherentsB")
public class AdherentListeServlet {
	
	private IAdherentDao adherentDao=new AdherentDao();
	

}
