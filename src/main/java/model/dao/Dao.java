package model.dao;

import java.util.List;

public interface Dao <T> {
	Integer save(T t);
	T load(int pk);
	T get(int pk);
	void update(T t);
	void delete(int pk);
	List<T> selectByHQL(String f);
}
