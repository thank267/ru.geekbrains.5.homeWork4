package ru.geekbrains.homework4.repositories;

import java.util.List;
import java.util.Optional;

public interface AbstractRepository<T, Long> {
	List<T> findAll();
	Optional<T> findById(Long id);
	void add(T t);
	void deleteById(Long id);

}
