package fr.gtm.films.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.films.dao.FilmDAO;
import fr.gtm.films.entities.Film;

public class TestDAO {
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
	public void test() {
		FilmDAO dao = new FilmDAO(emf);
		assertNotNull(dao);
	}

	@Test
	public void getAllFilmsTest() {
		FilmDAO dao = new FilmDAO(emf);
		List<Film> films = dao.getAllFilms();
		assertNotNull(films);
		assertEquals(1, films.size());
	}
	
	@Test
	public void getFilmByRealisateurTest() {
		FilmDAO dao = new FilmDAO(emf);
		List<Film> films = dao.getFilmByRealisateur("Stanley Kubrick");
		assertNotNull(films);
		assertEquals(1, films.size());
	}
	
	@Test
	public void testFilmActeurs() {
		FilmDAO dao = new FilmDAO(emf);
		Film film = dao.findById(1L);
		assertNotNull(film.getActeurs());
		assertEquals(2, film.getActeurs().size());
		
	}
}
