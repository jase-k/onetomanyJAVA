package com.jasekraft.dojos_ninjas.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasekraft.dojos_ninjas.mvc.models.Ninja;


@Repository
public interface NinjaRepo  extends CrudRepository<Ninja, Long>{
	// this method retrieves all the expenses from the database
	 List<Ninja> findAll();
	 
	// this method deletes an Ninja
	 Long deleteById(long id);
}
