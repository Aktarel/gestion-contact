package fr.nico.ail.contact.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import fr.nico.ail.contact.model.Adresse;
import fr.nico.ail.contact.model.Contact;

public class DummyDB {

	private Map<Integer, Contact> contacts = new HashMap<>();

	private Map<Integer, Adresse> adresses = new HashMap<>();

	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(DummyDB.class);

	private DummyDB() {
	}

	private static class DummyDBHolder {
		private final static DummyDB instance = new DummyDB();
	}

	public static DummyDB getInstance() {
		return DummyDBHolder.instance;
	}

	public void add(Object o) {

		if (o.getClass().equals(Contact.class)) {
			Contact contact = (Contact) o;
			contact.setIdContact(getNextIntContact());
			contacts.put(contact.getIdContact(), contact);
		}
		else if(o.getClass().equals(Adresse.class)){
			Adresse adresse = (Adresse) o;
			adresse.setIdAdresse(getNextIntAdresse());
			adresses.put(adresse.getIdAdresse(), adresse);
		}
		else{
			System.err.println("Vous essayez d'insérer un objet inconnu");
		}

	}

	public void deleteContact(int idContact) {
		contacts.remove(idContact);
	}
	public void deleteAdresse(int idAdresse) {
		adresses.remove(idAdresse);
	}

	public void update(Contact c) {
		contacts.put(c.getIdContact(), c);
	}

	public Collection<Contact> listContact() {
		return contacts.values();
	}

	public Contact get(int idContact) {
		return contacts.get(idContact);
	}

	public Collection<Adresse> listAdresses() {
		return adresses.values();
	}

	private int getNextIntContact(){
		int i = 0;
		while ( i < contacts.size() + 1 ) {
			if (contacts.containsKey(i)) {
				i++;
			} else {
				return i;
			}
		}
		return 0;
	}
	private int getNextIntAdresse(){
		int i = 0;
		while ( i < adresses.size() + 1 ) {
			if (adresses.containsKey(i)) {
				i++;
			} else {
				return i;
			}
		}
		return 0;
	}
}
