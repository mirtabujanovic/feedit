package com.java.feedit.core.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table( name = "CLANAK" )
public class Clanak {

	private Long id;
	private String naslov;
	private String autor;
	private String link;
	private LocalDate datumUnosa;
	private Integer brojGlasova;
	private Korisnik korisnik;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NonNull
	@Column( name = "NASLOV")
	public String getNaslov() {
		return naslov;
	}
	
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	
	@NonNull
	@Column( name = "AUTOR")
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@NonNull
	@Column( name = "LINK")
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	@NonNull
	@Column( name = "DATUM_UNOSA")
	public LocalDate getDatumUnosa() {
		return datumUnosa;
	}
	
	public void setDatumUnosa(LocalDate datumUnosa) {
		this.datumUnosa = datumUnosa;
	}
	
	@Column( name = "BROJ_GLASOVA")
	public Integer getBrojGlasova() {
		return brojGlasova;
	}
	
	public void setBrojGlasova(Integer brojGlasova) {
		this.brojGlasova = brojGlasova;
	}
	
	@ManyToOne()
	@JoinColumn( name = "KORISNIK_ID")
	public Korisnik getKorisnik() {
		return korisnik;
	}
	
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	@Override
	public String toString() {
		return "CLANAK [id=" + id + ", naslov=" + naslov + ", autor=" + autor + ", datumUnosa=" + datumUnosa
				+ ", brojGlasova=" + brojGlasova + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((brojGlasova == null) ? 0 : brojGlasova.hashCode());
		result = prime * result + ((datumUnosa == null) ? 0 : datumUnosa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clanak other = (Clanak) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (brojGlasova == null) {
			if (other.brojGlasova != null)
				return false;
		} else if (!brojGlasova.equals(other.brojGlasova))
			return false;
		if (datumUnosa == null) {
			if (other.datumUnosa != null)
				return false;
		} else if (!datumUnosa.equals(other.datumUnosa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naslov == null) {
			if (other.naslov != null)
				return false;
		} else if (!naslov.equals(other.naslov))
			return false;
		return true;
	}
	
}
