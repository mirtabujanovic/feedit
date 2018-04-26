package com.java.feedit.server.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KorisnikController {
	
	@RequestMapping("/api/korisnik")
	private Principal getTrenutniKorisnik(Principal korisnik) {
		return korisnik;
		
	}

}
