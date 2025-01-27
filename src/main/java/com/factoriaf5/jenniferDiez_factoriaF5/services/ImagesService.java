package com.factoriaf5.jenniferDiez_factoriaF5.services;

import java.util.List;
import java.util.Optional;

import com.factoriaf5.jenniferDiez_factoriaF5.valueObjects.ImagesVO;

public interface ImagesService {

	<S extends ImagesVO> List<S> saveAll(Iterable<S> entities);

	List<ImagesVO> findAll();

	<S extends ImagesVO> S save(S entity);

	void delete(ImagesVO entity);

	void deleteAll();
	
	long count();

	boolean existById(Integer id);

	Optional<ImagesVO> findById(Integer id);

	ImagesVO update(Optional<ImagesVO> img);
}