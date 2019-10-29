package fr.gtm.films.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.films.dao.FilmDAO;
import fr.gtm.films.entities.Acteur;
import fr.gtm.films.entities.Film;


public class TestDAO {
	private static EntityManagerFactory emf;
	final Logger tchikita = Logger.getLogger(TestDAO.class.getName());
	
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
		assertFalse(film.getActeurs().isEmpty());
		
	}
	@Test
	public void create() {
		FilmDAO dao = new FilmDAO(emf);
		Film film = new Film();
		List<Film> films1 = dao.getAllFilms();
		tchikita.info("la liste est égale à : "+films1.size());
		film.setTitre("Rasta Rockett");
		film.setDuree(98);
		film.setDateSortie(LocalDate.of(1994, 4, 13));
		
		Map<String, Acteur> roles = new HashMap<String, Acteur>();
		Acteur acteur = new Acteur("M", "Candy", "John");
		roles.put("Irv", acteur);
		
		film.setActeurs(roles);
		dao.create(film);
		
		List<Film> films2 = dao.getAllFilms();
		
		assertEquals(films1.size()+1, films2.size());
		
	}
	@Test
	public void delete() {
		FilmDAO dao = new FilmDAO(emf);
		List<Film> films = dao.getAllFilms();
		Film todelete = films.get(films.size()-1);
		dao.delete(todelete.getId());
	}
	
	@Test
	public void getRole() {
		FilmDAO dao = new FilmDAO(emf);
		Film film = dao.findById(1L);
		Map<String, Acteur> acteurs = film.getActeurs();
		assertTrue(acteurs.containsKey("aucun"));
	}
}
