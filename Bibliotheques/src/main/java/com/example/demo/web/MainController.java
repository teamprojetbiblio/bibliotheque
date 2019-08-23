package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	@Autowired
	private LivreRestService livre_service;
	
	@RequestMapping(value = { "/insertBook" }, method = RequestMethod.GET)
	public String index(HttpSession session) {
	
			return "insertBook";
		
	}
}
