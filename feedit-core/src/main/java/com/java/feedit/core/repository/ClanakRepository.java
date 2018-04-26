package com.java.feedit.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.java.feedit.core.domain.Clanak;
import com.java.feedit.core.domain.Korisnik;

@Repository
public interface ClanakRepository extends CrudRepository<Clanak, Long>, PagingAndSortingRepository<Clanak, Long>{

	@Query("select c from Clanak c where c.korisnik = ?1")
	public List<Clanak> fetchAllByKorisnik(Korisnik korisnik);
	
}
