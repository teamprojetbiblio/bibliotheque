package com.example.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.dao.AdherentDao;
import com.example.demo.dao.IAdherentDao;
import com.example.demo.entities.Adherent;
import com.sun.research.ws.wadl.Response;

@WebServlet("/adherentsB")
public class AdherentListeServlet extends HttpServlet {
	
	private IAdherentDao adherentDao=new AdherentDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		List<Adherent> listeAdherents=adherentDao.findAll();
		
		req.setAttribute("adherentListe",listeAdherents);
		
		HttpSession maSession= req.getSession(false);
		maSession.setAttribute("adherentListe",listeAdherents);
		
		resp.sendRedirect("adherents.jsp");
		
	}
	
	
	

}
