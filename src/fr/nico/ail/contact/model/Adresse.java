package fr.nico.ail.contact.model;

import java.util.ArrayList;
import java.util.List;

public class Adresse {

	private int idAdresse;
	
	private String numero;
	
	private String rue;
	
	private String codePostal;
	
	private String ville;

	private List<Contact> contacts = new ArrayList<Contact>();
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Adresse(String numero, String rue, String codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.numero)
		.append(" ")
		.append(rue)
		.append(" ")
		.append(codePostal)
		.append(" ")
		.append(ville);
		return sb.toString();
	}


	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public void add(Contact c){
		contacts.add(c);
	}

	
}
