package Persistance;

import java.util.List;

public interface DAO<T> {

	/**
	 * 
	 * @param id
	 */
	T get(int id);

	List<T> getAll();

	/**
	 * 
	 * @param t
	 */
	void save(T t);

	/**
	 * 
	 * @param t
	 */
	void update(T t);

	/**
	 * 
	 * @param t
	 */
	void delete(T t);

}