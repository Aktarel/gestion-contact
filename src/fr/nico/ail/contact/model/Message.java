package fr.nico.ail.contact.model;


/**
 * Represente un message que l'on souhaite passer à l'utilisateur dans la page web
 * @author nicolas
 *
 */
public class Message {

	/* Represente le contenu du message */
	private String content;
	
	/* Le type du message (voir l'enum MessageType)*/
	private MessageType type;


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Message(String content, MessageType type) {
		super();
		this.content = content;
		this.type = type;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
	
	
	
	
}
