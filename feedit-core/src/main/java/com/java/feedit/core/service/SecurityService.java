package com.java.feedit.core.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.feedit.core.domain.Korisnik;
import com.java.feedit.core.repository.KorisnikRepository;

@Service
@Transactional
public class SecurityService implements UserDetailsService, ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	private Logger log = LoggerFactory.getLogger(SecurityService.class);
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	public Korisnik findTrenutniKorisnik() {
		Authentication authentification = SecurityContextHolder.getContext().getAuthentication();
		if (authentification != null) {
			KorisnikUser korisnikUser = (KorisnikUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return korisnikUser.getKorisnik();
		}
		return null;
	}
	
	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		KorisnikUser korisnikUser = (KorisnikUser) event.getAuthentication().getPrincipal();
		Korisnik korisnik = korisnikUser.getKorisnik();
		log.info("Dohvaćeni korisnik je prijavljen: {}", korisnik);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Korisnik korisnik = korisnikRepository.findByUsername(username);
		if (korisnik == null) {
			log.debug("Korisnik {} nije pronađen.", username);
			throw new UsernameNotFoundException(username);
		}
		log.debug("Korisnik {} dohvaćen!", username);
		
		return new KorisnikUser(korisnik);
	}
	
	/**
	 * Implementacija {@link UserDetails } objekta kojeg se može koristiti kao spring security.
	 */
	private static class KorisnikUser extends User {
		
		private static final long serialVersionUID = 1L;
		private static final String ROLE_KORISNIK = "ROLE_KORISNIK";
		private Korisnik korisnik;
		
		private KorisnikUser(Korisnik korisnik) {
			super(korisnik.getUsername(), korisnik.getPassword(), getGrantedAuthorities());
			this.korisnik = korisnik;
		}

		public Korisnik getKorisnik() {
			return korisnik;
		}
		
		/**
		 * Metoda vraća pravo korisnika kao instancu {@link GrantedAuthority}. 
		 */
		private static Set<GrantedAuthority> getGrantedAuthorities() {
			Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority(ROLE_KORISNIK));
			return authorities;
		}
	}

}
