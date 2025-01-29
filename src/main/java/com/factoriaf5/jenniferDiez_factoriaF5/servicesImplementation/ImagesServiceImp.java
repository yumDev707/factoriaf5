package com.factoriaf5.jenniferDiez_factoriaF5.servicesImplementation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.factoriaf5.jenniferDiez_factoriaF5.repository.ImagesRepository;
import com.factoriaf5.jenniferDiez_factoriaF5.services.ImagesService;
import com.factoriaf5.jenniferDiez_factoriaF5.valueObjects.ImagesVO;

import jakarta.persistence.PersistenceException;

@Service
public class ImagesServiceImp implements ImagesService {
	
	@Autowired
	private ImagesRepository imgRep;

	@Override
	public boolean existById(Integer id) {
		return imgRep.existsById(id);
	}
	
	@Override
	public Optional<ImagesVO> findById(Integer id) {
		try {
			return imgRep.findById(id);
		} catch (Exception e) {
			if(e.getCause() == null) {
				System.out.println("Error searching the image: not exist in the BBDD");
				return Optional.of(new ImagesVO());
			}
			
			System.out.println("Error searching the image: "+ e.getCause());
			return Optional.empty();
		}
	}
	
	@Override
	public List<ImagesVO> findAll() {
		return imgRep.findAll();
	}

	@Override
	public <S extends ImagesVO> S save(S entity) {
		try {
			return imgRep.save(entity);
		} catch (PersistenceException e) {
			if(e.getCause() instanceof DataException)
				System.out.println("Error saving the image: data inconsistency");
			
			else if(e.getCause() instanceof ConstraintViolationException)
				System.out.println("Error saving the image: duplicate key");
			
			else
				System.out.println("Error saving the image: "+ e.getMessage());
			
			return entity;
		}
	}
	
	@Override
	public <S extends ImagesVO> List<S> saveAll(Iterable<S> entities) {
		return imgRep.saveAll(entities);
	}

	@Override
	public void delete(ImagesVO entity) {
		try {
			imgRep.delete(entity);
		} catch (NoSuchElementException e) {
			System.out.println("Error deleting a non-existent image: "+ e.getCause());
		}
	}

	@Override
	public void deleteAll() {
		imgRep.deleteAll();

	}

	@Override
	public long count() {
		return imgRep.count();
	}

	@Override
	public ImagesVO update(Optional<ImagesVO> img) {
		return imgRep.save(img.get());
	}
}