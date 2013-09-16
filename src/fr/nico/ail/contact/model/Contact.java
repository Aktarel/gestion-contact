package fr.nico.ail.contact.model;

public class Contact {

	
	private int idContact;
	
	private String nomContact;

	public String getNomContact() {
		return nomContact;
	}

	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}

	public int getIdContact() {
		return idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(int i, String string) {
		this.idContact = i ;
		this.nomContact = string;
	}

	public Contact(String nomContact2) {
		
		this.nomContact = nomContact2;
	}

	@Override
	public String toString() {
		return "Contact [idContact=" + idContact + ", nomContact=" + nomContact
				+ "]";
	}
	
	
}
