package fr.cdiEnterprise.model;

import java.util.List;
/**
 * 
 * @author Afpa
 *
 * @param <T>
 * 
 * Interface permettant de regrouper les fonctions CRUD
 * puis de les implementer dans la bonne classe
 */

public interface IRechercheAvancee<T> {
	boolean create(T o);
	boolean delete(T o);
	boolean update(T o);
	List<T> findAll();
	T findById(int id);
}

