package com.jasekraft.dojos_ninjas.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jasekraft.dojos_ninjas.mvc.models.Ninja;
import com.jasekraft.dojos_ninjas.mvc.repositories.NinjaRepo;

@Service
public class NinjaServ {
	private final NinjaRepo ninjaRepo;
	
	public NinjaServ(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja createNinja(Ninja d) {
		return ninjaRepo.save(d);
	}
	
	public Ninja getNinjaById(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}
		else {
			return null;
		}
		
	}
}
