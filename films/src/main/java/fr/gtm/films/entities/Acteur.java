package fr.gtm.films.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "acteurs")
@Access(AccessType.FIELD)
public class Acteur {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_acteur")
	private long id;
	private String civilite;
	private String nom;
	private String prenom;
	@Column(name = "date_naissance")
	private LocalDate naissance;
	@Column(name = "date_deces")
	private LocalDate deces;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="film_acteur",
			joinColumns = @JoinColumn(name="fk_acteur"),
			inverseJoinColumns = @JoinColumn(name="fk_film"))
	private List<Film> films = new ArrayList<Film>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getNaissance() {
		return naissance;
	}
	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	public LocalDate getDeces() {
		return deces;
	}
	public void setDeces(LocalDate deces) {
		this.deces = deces;
	}
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	
}
