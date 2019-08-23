package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class MainController {
	@Autowired
	private LivreRestService livre_service;
	

}
