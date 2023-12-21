package com.api.crud.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<E> {
	
	public List<E> getAll();
	
	public Optional<E> getById(Long id);
	
	public E updateById(Long id,E e);
	
	public void deleteById(Long id);
	
	public E create(E e);
	
	boolean exist(Long id);

}
