package fr.nico.ail.contact.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import fr.nico.ail.contact.model.Contact;

public class DummyDB {

	
	private Map<Integer, Contact> contacts = new HashMap<>();
	private Logger log = Logger.getLogger(DummyDB.class);
	
	private static DummyDB instance;

	public static DummyDB getInstance() {

		if (instance == null) {
			return new DummyDB();
		} else {
			return instance;
		}
	}

	public void add(Contact contact) {

		boolean flag = false;
		int i = 0;

		while (flag) {
			if (contacts.containsKey(i)) {
				contact.setIdContact(i);
				flag = true;
			}
			i++;
		}
		log.info("Contact crée "+contact);
		contacts.put(contact.getIdContact(), contact);
	}

	public void delete(int idContact) {

		contacts.remove(idContact);

	}

	public void update() {

	}

	public Collection<Contact> list() {
		return contacts.values();

	}

	public Contact get(int idContact) {
		return contacts.get(idContact);
	}

}
