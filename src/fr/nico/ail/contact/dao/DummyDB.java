package fr.nico.ail.contact.dao;

import java.util.Collection;

public interface DummyDB<T> {

	public void create(T o);
	
	public T read(int id);
	
	public void delete(int id);
	
	public void update(T o);
	
	public Collection<T> list();
}
