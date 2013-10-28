package fr.nico.ail.contact.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fr.nico.ail.contact.model.Contact;

public class ContactDAOImpl implements DummyDB<Contact> {

	private Map<Integer, Contact> contacts = new HashMap();
	
	private ContactDAOImpl() {
		
	}

	private static class ContactDAOImplHolder {
		private final static ContactDAOImpl instance = new ContactDAOImpl();
	}

	public static ContactDAOImpl getInstance() {
		return ContactDAOImplHolder.instance;
	}

	public void create(Contact o) {
		Contact contact = (Contact) o;
		contact.setIdContact(getNextIntContact());
		contacts.put(contact.getIdContact(), contact);
	}

	public Contact read(int id) {
		return contacts.get(id);
	}

	public void delete(int id) {
		contacts.remove(id);
	}

	public void update(Contact c) {
		contacts.put(c.getIdContact(),c);
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

	public Collection<Contact> list() {
		return contacts.values();
	}

}
