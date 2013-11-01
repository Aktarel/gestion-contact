package fr.nico.ail.contact.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.nico.ail.contact.dao.DummyDB;
import fr.nico.ail.contact.dao.impl.AdresseDAOImpl;
import fr.nico.ail.contact.dao.impl.ContactDAOImpl;
import fr.nico.ail.contact.model.Adresse;
import fr.nico.ail.contact.model.Contact;
import fr.nico.ail.contact.model.Message;
import fr.nico.ail.contact.model.MessageType;



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
		private DummyDB<Contact> contactDAO = ContactDAOImpl.getInstance();
		
		private DummyDB<Adresse> adresseDAO = AdresseDAOImpl.getInstance();
		
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
			
			
			adresseDAO.create(a1);
			adresseDAO.create(a2);
			adresseDAO.create(a3);
			adresseDAO.create(a4);
			adresseDAO.create(a5);
			adresseDAO.create(a6);
			
			
			
			contactDAO.create(c);
			contactDAO.create(c2);
			contactDAO.create(c3);
			contactDAO.create(c4);
			contactDAO.create(c5);
			contactDAO.create(c6);
			contactDAO.create(c7);
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
	    	model.addAttribute("contact",contactDAO.read(idContact));
	    	
	        return "contact/affichage";
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
	    	model.addAttribute("adresses",adresseDAO.list());
	    	model.addAttribute("section","contact");
	        return "contact/form/ajoutContact";
	    }
	    
	    @RequestMapping("/creer-1")
	    public String creationContact(@RequestParam String nom, @RequestParam String dateNaissance, @RequestParam String email, @RequestParam int adresse,@RequestParam(required=false) boolean isActive,Model model) {
	    	
	    	log.info("> demande de creation step 1 ");
	    	String dateFinale;
  	    	String[] date = dateNaissance.split("-");
  	    	
  	    	/* En cas de mauvais support HTML 5 [ MSIE && Mozilla firefox]*/
  	    	if(date.length<3){
  	    		dateFinale = dateNaissance;
  	    	}
  	    	else{
  	    		dateFinale = date[2]+"/"+date[1]+"/"+date[0];
  	    	}
  	    	
	    	try {
				contactDAO.create(new Contact(nom,email,sdf.parse(dateFinale),adresseDAO.read(adresse),isActive));
				model.addAttribute("message", new Message("Utilisateur ajoutée avec succes",MessageType.succes));
	    	} catch (ParseException e) {
	    		model.addAttribute("message", new Message("Echec dans l'ajout de l'utilisateur "+nom,MessageType.erreur));
				e.printStackTrace();
			}
	    	
	    	model.addAttribute("section","contact");
	    	
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
	    	model.addAttribute("contacts", contactDAO.list());
	    	model.addAttribute("section","contact");
	    	return "contact/lister";
	    }
	    
	    
	    /**
		 * Permet de supprimer un contact de la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    @RequestMapping("/supprimer")
	    public String suppressionContact(@RequestParam int idContact,Model model) {
	    	
	    	log.info("> demande de suppression");
	    	contactDAO.delete(idContact);
	    	
	    	model.addAttribute("message", new Message("Suppression du contact accomplie",MessageType.succes));
	    	
	    	return listerContact(model);
	    }
	    
	    /**
		 * Permet de mettre à jour un contact dans la map mesContacts
		 * @param model : le modèle à renvoyer à la vue
		 * @return le chemin vers la vue (jsp)
		 */
	    @RequestMapping("/maj-0")
	    public String updateFormContact(@RequestParam String idContact,Model model) {
	    	
	    	model.addAttribute("contact", contactDAO.read(Integer.parseInt(idContact)));
	    	model.addAttribute("adresses",adresseDAO.list());
	    	model.addAttribute("section","contact");
	    	return "contact/form/updateContact";
	    	
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
	  	    	String dateFinale;
	  	    	String[] date = dateNaissance.split("-");
	  	    	
	  	    	/* En cas de mauvais support HTML 5 [ MSIE && Mozilla firefox]*/
	  	    	if(date.length<3){
	  	    		dateFinale = dateNaissance;
	  	    	}
	  	    	else{
	  	    		dateFinale = date[2]+"/"+date[1]+"/"+date[0];
	  	    	}
	  	    	
	  	    	contactDAO.delete(Integer.parseInt(idContact));
	  	    	Adresse adresse = adresseDAO.read(idAdresse);
		  	    
	  	    	Contact contact = null;
				try {
					contact = new Contact(nomContact,email,sdf.parse(dateFinale),adresse,isActive);
					contactDAO.create(contact);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	    	
	  	    	model.addAttribute("message", new Message("Mise à jour des information reussies",MessageType.succes));
	  	    	
	  	    	return listerContact(model);
	  	    	
	  	    }
}
