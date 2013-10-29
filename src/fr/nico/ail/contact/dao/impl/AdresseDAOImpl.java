package fr.nico.ail.contact.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fr.nico.ail.contact.dao.DummyDB;
import fr.nico.ail.contact.model.Adresse;

public class AdresseDAOImpl implements DummyDB<Adresse> {

	private Map<Integer, Adresse> adresses = new HashMap<Integer,Adresse>();	
	
	private AdresseDAOImpl() {
	}

	private static class AdresseDAOImplHolder {
		private final static AdresseDAOImpl instance = new AdresseDAOImpl();
	}

	public static AdresseDAOImpl getInstance() {
		return AdresseDAOImplHolder.instance;
	}
	
	public void create(Adresse o) {
		Adresse adresse = (Adresse) o;
		adresse.setIdAdresse(getNextIntAdresse());
		adresses.put(adresse.getIdAdresse(), adresse);
	}

	public Adresse read(int id) {
		return adresses.get(id);
	}

	public void delete(int id) {
		adresses.remove(id);
	}

	public void update(Adresse a) {
		adresses.put(a.getIdAdresse(),a);		
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

	@Override
	public Collection<Adresse> list() {
		return adresses.values();
	}
	

}
