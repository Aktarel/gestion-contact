package fr.nico.ail.contact.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.nico.ail.contact.dao.DummyDB;
import fr.nico.ail.contact.dao.impl.AdresseDAOImpl;
import fr.nico.ail.contact.dao.impl.ContactDAOImpl;
import fr.nico.ail.contact.model.Adresse;
import fr.nico.ail.contact.model.Contact;
import fr.nico.ail.contact.model.Message;
import fr.nico.ail.contact.model.MessageType;

/**
 * Controlleur Adresse : dispatch les requetes entre les vues jsp
 * /WEB-INF/jsp/adresse/* et le modele (DAO)
 * 
 * @author nicolas
 * @since 13/09/2013
 */

@Controller
@RequestMapping("/adresse/*")
public class AdresseController {

	private Logger log = Logger.getLogger(AdresseController.class);

	/**
	 * La map contient les contient les contacts et simule ma couche de
	 * persistance
	 */
	private DummyDB<Adresse> adresseDAO = AdresseDAOImpl.getInstance();

	private DummyDB<Contact> contactDAO = ContactDAOImpl.getInstance();

	/* Constructeur */
	public AdresseController() {

	}

	/**
	 * Permet de créer un contact en insérant un objet contact dans la map
	 * mesContacts
	 * 
	 * @param nomContact
	 *            : le nom du contact pour lequel on veut créer un contact
	 * @param model
	 *            : le modèle à renvoyer à la vue
	 * @return le chemin vers la vue (jsp) - on revient à la liste des contacts
	 */
	@RequestMapping("/creer-0")
	public String creationFormAdresse(Model model) {

		log.info("> demande de creation step 0 ");
		model.addAttribute("section", "adresse");
		return "adresse/form/ajoutAdresse";
	}

	/**
	 * Permet de créer un contact en insérant un objet contact dans la map
	 * mesContacts
	 * 
	 * @param nomContact : le nom du contact pour lequel on veut créer un contact
	 * @param model : le modèle à renvoyer à la vue
	 * @return le chemin vers la vue (jsp) - on revient à la liste des contacts
	 */
	@RequestMapping("/creer-1")
	public String creationAdresse(@RequestParam String numero,
			@RequestParam String rue, @RequestParam String ville,
			@RequestParam String codePostal, Model model) {

		log.info("> demande de creation step 1 ");
		adresseDAO.create(new Adresse(numero, rue, codePostal, ville));

		model.addAttribute("message", new Message("Succès dans la création de l'adresse", MessageType.succes));
		return listerAdresse(model);
	}

	/**
	 * Permet de lister l'ensemble des contacts contenus dans la map mesContacts
	 * 
	 * @param model
	 *            : le modèle à renvoyer à la vue
	 * @return le chemin vers la vue (jsp)
	 */

	@RequestMapping("/lister")
	public String listerAdresse(Model model) {

		log.info("> demande de listing");
		model.addAttribute("section", "adresse");
		model.addAttribute("adresses", adresseDAO.list());
		return "adresse/lister";
	}

	/**
	 * Permet de supprimer un contact de la map mesContacts
	 * 
	 * @param model
	 *            : le modèle à renvoyer à la vue
	 * @return le chemin vers la vue (jsp)
	 */
	@RequestMapping("/supprimer")
	public String supprimerAdresse(@RequestParam int idAdresse, Model model) {

		StringBuilder contactConcat = new StringBuilder();
		log.info("> demande de suppression");
		Adresse a = adresseDAO.read(idAdresse);

		List<Contact> contactsLieAdresse = a.getContacts();
		for (Contact c : contactsLieAdresse) {
			c.setAdresse(null);
			contactDAO.update(c);
			contactConcat.append("<a href=\"/contact/maj-0?idContact="
					+ c.getIdContact() + "\">" + c.getNomContact() + "</a> ");
		}

		adresseDAO.delete(idAdresse);

		if (contactConcat.length() > 0)
			model.addAttribute("message", new Message(
					"Suppression effectué ! Pensez à ré-adresser les contacts suivant : "
							+ contactConcat.toString(), MessageType.alerte));
		else
			model.addAttribute("message", new Message(
					"Suppression effectué ! ", MessageType.succes));

		return listerAdresse(model);
	}

	/**
	 * Permet de mettre à jour un contact dans la map mesContacts
	 * 
	 * @param model
	 *            : le modèle à renvoyer à la vue
	 * @return le chemin vers la vue (jsp)
	 */
	@RequestMapping("/maj-0")
	public String miseJourAdresse(Model model) {

		log.info("> demande de mise à jour");
		model.addAttribute("section", "adresse");
		return "adresse/form/updateAdresse";

	}

	/**
	 * Permet de mettre à jour un contact dans la map mesContacts
	 * 
	 * @param model
	 *            : le modèle à renvoyer à la vue
	 * @return le chemin vers la vue (jsp)
	 */
	@RequestMapping("/maj-1")
	public String miseJourAdresseFinaleStep(Model model) {

		log.info("> demande de mise à jour");
		return "adresse/form/updateAdresse";

	}
}
