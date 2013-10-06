package fr.nico.ail.contact.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.nico.ail.contact.dao.DummyDB;
import fr.nico.ail.contact.model.Contact;



/**
 *  TODO : Ajouter un système de validation des champs
 * 		> Placer sur google app engine ou github
 *      > Surtout PAS de persistance
 *      > A rendre avant le Lundi 4 Novembre AVANT 16H
 *      > Communiquer les binomes pour le vendredi 27 Octobre à l'adresse : nicolas.andre@gleetr.net 
 * 
 * @author nicolas
 * @since 13/09/2013
 */

@Controller
@RequestMapping("/adresse/*")
public class AdresseController  {
	
	
		private Logger log = Logger.getLogger(AdresseController.class);
		
		/**
		 *  La map contient les contient les contacts et simule ma couche de persistance
		 */
		private DummyDB dummyDB = DummyDB.getInstance();
		
		/* Constructeur */
		public AdresseController() {

			
			/* Mon jeu de donnée */
			dummyDB.add( new Contact("King"));
			dummyDB.add(new Contact("Merkel"));
			dummyDB.add(new Contact("Coppé"));
			dummyDB.add(new Contact("Alassad"));
			dummyDB.add(new Contact("Hollande"));
		}
		
		
	    
		/**
		 * Permet d'afficher les informations d'un contact
		 * @param idContact : l'identifiant (integer) / la clef dans la map
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp) - on revient à la liste des contacts
		 */
	    @RequestMapping(value={"/afficher"},method=RequestMethod.GET)
	    public String affichageAdresse(@RequestParam int idContact ,Model model) {
	    	
	    	log.info("> demande d'affichage");
	  
	        return "/contact/affichage";
	    }
		
	    /**
		 * Permet de créer un contact en insérant un objet contact dans la map mesContacts
		 * @param nomContact : le nom du contact pour lequel on veut créer un contact
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp) - on revient à la liste des contacts
		 */
	    @RequestMapping("/creer")
	    public String creationAdresse(@RequestParam String nomContact, @RequestParam String date, @RequestParam String email ,Model model) {
	    	
	    	log.info("> demande de creation");
	        return listerAdresse(model);
	    }

	    /**
		 * Permet de lister l'ensemble des contacts contenus dans la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    
	    @RequestMapping("/lister")
	    public String listerAdresse(Model model) {
	    	
	    	log.info("> demande de listing");
	    	return "/contact/lister";
	    }
	    
	    
	    /**
		 * Permet de supprimer un contact de la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    @RequestMapping("/supprimer")
	    public String supprimerContact(@RequestParam int idContact,Model model) {
	    	
	    	log.info("> demande de suppression");
	    	return listerAdresse(model);
	    }
	    
	    /**
		 * Permet de mettre à jour un contact dans la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    @RequestMapping("/maj")
	    public String miseJourAdresse(Model model) {
	    	
	    	log.info("> demande de mise à jour");
	    	return listerAdresse(model);
	    	
	    }
}
