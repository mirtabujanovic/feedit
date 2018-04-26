package com.java.feedit.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.feedit.core.domain.Clanak;
import com.java.feedit.core.domain.Korisnik;
import com.java.feedit.core.repository.ClanakRepository;

@Service
public class FeeditService {
	
	@Autowired
	private ClanakRepository clanakRepository;
	
	public List<Clanak> dohvatiSveClanke(Korisnik korisnik) {
		return clanakRepository.fetchAllByKorisnik(korisnik);
	}
	
	public Page<Clanak> dohvatiClanke(Korisnik korisnik, Pageable pageable) {
		return clanakRepository.findAll(pageable);
	}
	
	public Clanak spremiClanak(Clanak clanak) {
		return clanakRepository.save(clanak);
	}
	
	public void obrisiClanak(Clanak clanak) {
		clanakRepository.delete(clanak);
	}

}
