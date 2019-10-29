package fr.gtm.films.dao;

import javax.persistence.EntityManagerFactory;

import fr.gtm.films.entities.Acteur;

public class ActeurDAO extends AbstractDAO<Acteur, Long> {

	public ActeurDAO(EntityManagerFactory emf) {
		super(emf, Acteur.class);
		// TODO Auto-generated constructor stub
	}
	
	

}
