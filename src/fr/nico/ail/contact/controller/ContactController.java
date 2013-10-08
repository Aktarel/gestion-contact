package fr.nico.ail.contact.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.nico.ail.contact.dao.DummyDB;
import fr.nico.ail.contact.model.Adresse;
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
@RequestMapping("/contact/*")
public class ContactController  {
	
	
		private Logger log = Logger.getLogger(ContactController.class);
		
		/**
		 *  La map contient les contient les contacts et simule ma couche de persistance
		 */
		private DummyDB dummyDB = DummyDB.getInstance();
		
		/* Constructeur */
		public ContactController() {

			List<Adresse> adresses = new ArrayList<>();
			adresses.add(new Adresse("30","Rue Tolbiac","75013","Paris"));
			adresses.add(new Adresse("170","Rue des rabats","92160","Antony"));
			Contact c = new Contact("Salomon");
			c.setAdresses(adresses);
			c.setEmail("salomon@gmail.com");
			c.setDateNaissance(new Date());
			c.setActif(true);
			
			dummyDB.add(c);
			dummyDB.add(new Contact("Scott"));
			dummyDB.add(new Contact("Parker"));
			dummyDB.add(new Contact("Farell"));
		}
		
		
	    
		/**
		 * Permet d'afficher les informations d'un contact
		 * @param idContact : l'identifiant (integer) / la clef dans la map
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp) - on revient à la liste des contacts
		 */
	    @RequestMapping(value={"/afficher"},method=RequestMethod.GET)
	    public String affichageContact(@RequestParam int idContact ,Model model) {
	    	
	    	log.info("> demande d'affichage");
	    	model.addAttribute("contact",dummyDB.get(idContact));
	  
	        return "/contact/affichage";
	    }
		
	    /**
		 * Permet de créer un contact en insérant un objet contact dans la map mesContacts
		 * @param nomContact : le nom du contact pour lequel on veut créer un contact
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp) - on revient à la liste des contacts
		 */
	    @RequestMapping("/creer-0")
	    public String creationFormContact(Model model) {
	    	
	    	log.info("> demande de creation step 0 ");
	    	
	        return "/contact/form/ajoutContact";
	    }
	    
	    @RequestMapping("/creer-1")
	    public String creationContact(@RequestParam String nom, @RequestParam String dateNaissance, @RequestParam String email,Model model) {
	    	
	    	log.info("> demande de creation step 1 ");
	    	dummyDB.add(new Contact(nom));
	    	
	        return listerContact(model);
	    }

	    /**
		 * Permet de lister l'ensemble des contacts contenus dans la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    
	    @RequestMapping("/lister")
	    public String listerContact(Model model) {
	    	
	    	log.info("> demande de listing");
	    	model.addAttribute("contacts", dummyDB.listContact());
	    	
	    	return "/contact/lister";
	    }
	    
	    
	    /**
		 * Permet de supprimer un contact de la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    @RequestMapping("/supprimer")
	    public String suppressionContact(@RequestParam int idContact,Model model) {
	    	
	    	log.info("> demande de suppression");
	    	dummyDB.deleteContact(idContact);
	    	
	    	return listerContact(model);
	    }
	    
	    /**
		 * Permet de mettre à jour un contact dans la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    @RequestMapping("/maj-0")
	    public String miseJourFormContact(@RequestParam String idContact,Model model) {
	    	
	    	model.addAttribute("contact", dummyDB.get(Integer.parseInt(idContact)));
	    	return "/contact/form/updateContact";
	    	
	    }
	    
	    /**
	  		 * Permet de mettre à jour un contact dans la map mesContacts
	  		 * @param model : le modèle à renvoyer à la vue
	  		 * @return le chemin vers la vue (jsp)
	     * @throws ParseException 
	  		 */
	  	    @RequestMapping("/maj-1")
	  	    public String miseJourFinalStep(@RequestParam String idContact,@RequestParam String nomContact,@RequestParam String email, @RequestParam String dateNaissance , @RequestParam boolean isActive,Model model) throws ParseException {
	  	    	
	  	    	log.info("> demande de mise à jour ");
	  	    	log.info("> on supprime "+idContact);
	  	    	dummyDB.deleteContact(Integer.parseInt(idContact));
	  	    	
	  	    	Contact contact = new Contact();
	  	    	contact.setNomContact(nomContact);
	  	    	contact.setEmail(email);
	  	    	contact.setDateNaissance(new SimpleDateFormat("dd/mm/yyyy").parse(dateNaissance));
	  	    	contact.setActif(isActive);
	  	    	dummyDB.add(contact);
	  	    	
	  	    	return listerContact(model);
	  	    	
	  	    }
}
