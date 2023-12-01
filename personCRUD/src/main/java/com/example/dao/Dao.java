package com.example.dao;

import java.util.List;

public interface Dao<T> {

	List<T> getAll();

	T getById(int id);

	void save(String nom,int nni);

	void update(T t, int params[]);

	void delete(int t);
}