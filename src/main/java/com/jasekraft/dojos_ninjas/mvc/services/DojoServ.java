package com.jasekraft.dojos_ninjas.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jasekraft.dojos_ninjas.mvc.models.Dojo;
import com.jasekraft.dojos_ninjas.mvc.repositories.DojoRepo;

@Service
public class DojoServ {
	private final DojoRepo dojoRepo;
	
	public DojoServ(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> getAllDojos(){
		List<Dojo> dojos = dojoRepo.findAll();
		return dojos;
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public Dojo getDojoById(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
		
	}
}
