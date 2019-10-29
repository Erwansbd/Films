package fr.gtm.films.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.films.entities.Film;

public class FilmDAO extends AbstractDAO<Film, Long>{
	
	public FilmDAO(EntityManagerFactory emf) {
		super(emf,Film.class);
	}
	
	public List<Film> getAllFilms() {
		EntityManager em = getEMF().createEntityManager();
		List<Film> films = em.createNamedQuery("getAllFilms", Film.class).getResultList();
		em.close();
		return films;
		
	}
	
	public List<Film> getFilmByRealisateur(String realisateur) {
		EntityManager em = getEMF().createEntityManager();
		List<Film> films = em.createNamedQuery("getFilmByRealisateur", Film.class)
								.setParameter("realisateur", realisateur)
								.getResultList();
		em.close();
		return films;
		
	}

}
