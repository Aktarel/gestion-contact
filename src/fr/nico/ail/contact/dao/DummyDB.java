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


	private DummyDB()
	{}
 
	private static class DummyDBHolder
	{		
		private final static DummyDB instance = new DummyDB();
	}
 
	public static DummyDB getInstance()
	{
		return DummyDBHolder.instance;
	}
	
	
	
	public void add(Contact contact) {

		boolean flag = false;
		int i = 0;

		while (flag==false && i<contacts.size()+1) {
			if (contacts.containsKey(i)) {
				i++;
			}else{
				contact.setIdContact(i);
				flag = true;
			}
		}
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
