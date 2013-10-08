package fr.nico.ail.contact.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {

	
	private int idContact;
	
	private String nomContact;

	private String email;
	
	private Date dateNaissance;
	
	//Pour mapper la relation ManyToOne
	private Adresse adresse;
	
	private boolean actif;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String getDateNaissanceToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (dateNaissance == null) {
			return new String();
		} else {
			return sdf.format(dateNaissance);
		}
		
		
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Contact(String nomContact, String email, Date dateNaissance,
			Adresse adresse, boolean actif) {
		super();
		this.nomContact = nomContact;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.actif = actif;
	}

	
	
	
}
