package fr.nico.ail.contact.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fr.nico.ail.contact.model.Contact;

public class DummyDB {

	private Map<Integer, Contact> contacts = new HashMap<>();

	private static DummyDB instance;

	public static DummyDB getInstance() {

		if (instance == null) {
			return new DummyDB();
		} else {
			return instance;
		}
	}

	public void add(Contact contact) {

//		int id = 0;
//
//		for (int i = 0; i < 1000; i++) {
//			if (contacts.containsKey(i)){
//				id = i;
//				break;
//			}
//		}
//		
//		contact.setIdContact(id);
		contact.setIdContact(contacts.size()+1);
		contacts.put(contacts.size()+1, contact);
	}

	public void delete(int idContact) {

		contacts.remove(idContact);
		
	}

	public void update() {

	}
	
	public Collection<Contact> list(){
    	return contacts.values();

		
	}

	public Contact get(int idContact) {
		return contacts.get(idContact);
	}
	

}
