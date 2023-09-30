package model;

import java.io.Serializable;
import java.util.Collection;

/**
 * Generated at Tue Apr 14 19:54:58 EEST 2015
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public interface GenericDAO<T, ID extends Serializable> {
	
	T getById(ID id, boolean lock);

	T getById(ID id);

	T loadById(ID id);

	Collection<T> findAll();

	void save(T entity);

	void update(T entity);

	void delete(T entity);

	void deleteById(ID id);

}