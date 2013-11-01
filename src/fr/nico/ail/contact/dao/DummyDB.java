package fr.nico.ail.contact.dao;

import java.util.Collection;


/**
 * 
 * Interface permettant de d�finir les sp�cifications requises 
 * � l'�laboration d'un DAO
 * @author nicolas
 * @param <T>  : generique qui permet de manipuler l'objet souhaiter
 */
public interface DummyDB<T> {

	/**
	 * Creer un objet
	 * @param o : l'objet demand�
	 */
	public void create(T o);
	
	/**
	 * Permet de restitu� un objet
	 * @param id : id de l'objet dans la base
	 * @return l'objet typ� � l'initialisation de l'impl�mentation
	 */
	public T read(int id);
	
	/**
	 * Permet de supprimer un objet de type T
	 * @param id : l'id de l'objet � supprimer
	 */
	public void delete(int id);
	
	/**
	 * Permet de modifier l'objet
	 * @param o : l'objet en question qui a �t� modifi� via les setter/getter
	 */
	public void update(T o);
	
	/**
	 * Renvoie une collection de l'objet generique
	 * @return Collection : list non ordonn�e de type T
	 */
	public Collection<T> list();
}
