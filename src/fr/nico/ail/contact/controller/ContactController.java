package fr.nico.ail.contact.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.istack.internal.NotNull;

import fr.nico.ail.contact.dao.DummyDB;
import fr.nico.ail.contact.model.Adresse;
import fr.nico.ail.contact.model.Contact;
import fr.nico.ail.contact.model.Message;



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
		
		private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/* Constructeur */
		public ContactController() throws ParseException {

			Adresse a1 = new Adresse("30", "Rue Tolbiac","75013", "Paris");
			Adresse a2 = new Adresse("10", "Rue de la Paix","75001", "Paris");
			Adresse a3 = new Adresse("18", "Avenue de Foch","94160", "St-Mandé");
			Adresse a4 = new Adresse("185", "Rue de Solférino","59160", "Lille");
			Adresse a5 = new Adresse("170", "Rue des rabats","92160", "Antony");
			Adresse a6 = new Adresse("15", "Rue des allouettes","92320", "Chatillon");
			
			Contact c = new Contact("Salomon","Salomon@gmail.com",sdf.parse("18/03/1978"),a1,true);
			Contact c2 = new Contact("John Parker","parker@orange.com",sdf.parse("12/01/1968"),a2,true);
			Contact c3 = new Contact("King","king@yahoo.com",sdf.parse("21/04/1975"),a3,true);
			Contact c4 = new Contact("Georgio","georgio@free.fr",sdf.parse("14/07/1990"),a4,false);
			Contact c5 = new Contact("King Jr","king-jr@yahoo.com",sdf.parse("11/04/2001"),a5,false);
			Contact c6 = new Contact("Jessica Parker","jess-sexygirl69@hotmail.com",sdf.parse("14/08/1972"),a2,true);
			Contact c7 = new Contact("Sti glitz","sti-glitz@deutch-bank.de",sdf.parse("21/12/1986"),a6,false);
			
			
			
			dummyDB.add(a1);
			dummyDB.add(a2);
			dummyDB.add(a3);
			dummyDB.add(a4);
			dummyDB.add(a5);
			dummyDB.add(a6);
			
			
			
			dummyDB.add(c);
			dummyDB.add(c2);
			dummyDB.add(c3);
			dummyDB.add(c4);
			dummyDB.add(c5);
			dummyDB.add(c6);
			dummyDB.add(c7);
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
	    	model.addAttribute("adresses",dummyDB.listAdresses());
	    	
	        return "/contact/form/ajoutContact";
	    }
	    
	    @RequestMapping("/creer-1")
	    public String creationContact(@RequestParam String nom, @RequestParam String dateNaissance, @RequestParam String email, @RequestParam int adresse,@RequestParam(required=false) boolean isActive,Model model) {
	    	
	    	log.info("> demande de creation step 1 ");
	    	try {
				dummyDB.add(new Contact(nom,email,sdf.parse(dateNaissance),dummyDB.getAdresse(adresse),isActive));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	model.addAttribute("message", new Message("Utilisateur ajoutée avec succes","alert alert-success"));
	    	
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
	    	
	    	model.addAttribute("message", new Message("Suppression du contact accomplie","alert alert-success"));
	    	
	    	return listerContact(model);
	    }
	    
	    /**
		 * Permet de mettre à jour un contact dans la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    @RequestMapping("/maj-0")
	    public String updateFormContact(@RequestParam String idContact,Model model) {
	    	
	    	model.addAttribute("contact", dummyDB.get(Integer.parseInt(idContact)));
	    	model.addAttribute("adresses",dummyDB.listAdresses());
	    	
	    	return "/contact/form/updateContact";
	    	
	    }
	    
	    /**
	  		 * Permet de mettre à jour un contact dans la map mesContacts
	  		 * @param model : le modèle à renvoyer à la vue
	  		 * @return le chemin vers la vue (jsp)
	     * @throws ParseException 
	  		 */
	  	    @RequestMapping("/maj-1")
	  	    public String updateFinalStep(@RequestParam String idContact,@RequestParam String nomContact,@RequestParam String email, @RequestParam String dateNaissance , @RequestParam int idAdresse,@RequestParam(required=false) boolean isActive,Model model) {
	  	    	log.info("> demande de mise à jour ");
	  	    	dummyDB.deleteContact(Integer.parseInt(idContact));
	  	    	Adresse adresse = dummyDB.getAdresse(idAdresse);
		  	    
	  	    	Contact contact = new Contact();
	  	    	contact.setNomContact(nomContact);
	  	    	contact.setEmail(email);
	  	  	
				try {
					contact.setDateNaissance(sdf.parse(dateNaissance));
				} catch (ParseException e) {
					e.printStackTrace();
				}
	  	    	
	  	    	contact.setAdresse(adresse);
	  	    	contact.setActif(isActive);
	  	    	dummyDB.add(contact);
	  	    	
	  	    	model.addAttribute("message", new Message("Mise à jour des information reussies","alert alert-success"));
	  	    	
	  	    	return listerContact(model);
	  	    	
	  	    }
}
