package fr.gtm.films.dao;

import javax.persistence.EntityManagerFactory;

import fr.gtm.films.entities.Film;

public class FilmDAO extends AbstractDAO<Film, Long>{
	
	public FilmDAO(EntityManagerFactory emf) {
		super(emf,Film.class);
	}
	
	

}
