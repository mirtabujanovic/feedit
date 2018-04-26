package com.java.feedit.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.feedit.core.domain.Korisnik;

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Long>{
	
	public Korisnik findByUsername(String username);

}
