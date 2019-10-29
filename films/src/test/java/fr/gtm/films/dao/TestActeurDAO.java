package fr.gtm.films.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.films.entities.Acteur;
import fr.gtm.films.entities.Film;

public class TestActeurDAO {

	private static EntityManagerFactory emf;
	
	@BeforeClass
	public static void before() {
		emf = Persistence.createEntityManagerFactory("films");
	}
	
	@AfterClass
	public static void after() {
		if(emf!=null) {
			emf.close();
		}
	}
	
	@Test
	public void testActeurFilms() {
		ActeurDAO dao = new ActeurDAO(emf);
		Acteur acteur = dao.findById(2L);
		assertNotNull(acteur.getFilms());
		assertEquals(1, acteur.getFilms().size());
		
	}

}
