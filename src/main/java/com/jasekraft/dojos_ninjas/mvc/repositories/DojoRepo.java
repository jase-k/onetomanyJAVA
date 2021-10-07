package com.jasekraft.dojos_ninjas.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasekraft.dojos_ninjas.mvc.models.Dojo;


@Repository
public interface DojoRepo  extends CrudRepository<Dojo, Long>{
	// this method retrieves all the expenses from the database
	 List<Dojo> findAll();
	 
	// this method deletes an Dojo
	 Long deleteById(long id);
}
