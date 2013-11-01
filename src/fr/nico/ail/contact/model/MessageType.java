package fr.nico.ail.contact.model;

public enum MessageType {
	
	succes("alert alert-success"),
	alerte("alert alert-warning"),
	erreur("alert alert-error");
	 
	 private String correspondance = "";

	private MessageType(String correspondance) {
		this.setCorrespondance(correspondance);
	}

	public String getCorrespondance() {
		return correspondance;
	}

	public void setCorrespondance(String correspondance) {
		this.correspondance = correspondance;
	}
	    	
}
