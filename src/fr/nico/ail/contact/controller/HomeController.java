package fr.nico.ail.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/accueil/*","/"})
public class HomeController {

	@RequestMapping("/")
	public String home(Model modele){
		return "accueil/welcome";
	}
	
}
