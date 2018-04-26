package com.java.feedit.core.config;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.java.feedit.core.domain.Korisnik;
import com.java.feedit.core.repository.KorisnikRepository;

/**
 * Inicijali insert korisnika aplikacije. 
 */

@Component
public class DataInitialization {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	@Transactional
	public void insertData() {
		
		Korisnik korisnik = new Korisnik();
		korisnik.setUsername("admin");
		korisnik.setPassword(passwordEncoder.encode("123456"));
		korisnikRepository.save(korisnik);
	}
	
}
