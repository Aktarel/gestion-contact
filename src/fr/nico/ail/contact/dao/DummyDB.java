package fr.nico.ail.contact.dao;

import java.util.Collection;


/**
 * 
 * Interface permettant de définir les spécifications requises 
 * à l'élaboration d'un DAO
 * @author nicolas
 * @param <T>  : generique qui permet de manipuler l'objet souhaiter
 */
public interface DummyDB<T> {

	/**
	 * Creer un objet
	 * @param o : l'objet demandé
	 */
	public void create(T o);
	
	/**
	 * Permet de restitué un objet
	 * @param id : id de l'objet dans la base
	 * @return l'objet typé à l'initialisation de l'implémentation
	 */
	public T read(int id);
	
	/**
	 * Permet de supprimer un objet de type T
	 * @param id : l'id de l'objet à supprimer
	 */
	public void delete(int id);
	
	/**
	 * Permet de modifier l'objet
	 * @param o : l'objet en question qui a été modifié via les setter/getter
	 */
	public void update(T o);
	
	/**
	 * Renvoie une collection de l'objet generique
	 * @return Collection : list non ordonnée de type T
	 */
	public Collection<T> list();
}
