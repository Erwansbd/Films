package fr.gtm.films.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "films")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = "getAllFilms", query = "SELECT f FROM Film f"),
		@NamedQuery(name = "getFilmByRealisateur", query = "SELECT f FROM Film f WHERE LOWER(f.realisateur) LIKE :realisateur")
})
public class Film {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_film")
	private long id;
	private String titre;
	@Column(name = "realisateur")
	private String realisateur;
	@Column(name = "date_sortie")
	private LocalDate dateSortie;
	private int duree; //durée en minutes;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="film_acteur",
	joinColumns = @JoinColumn(name="fk_film"),
	inverseJoinColumns = @JoinColumn(name="fk_acteur"))
	@MapKeyColumn(name = "role")
	Map<String, Acteur> acteurs = new HashMap<String, Acteur>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Map<String, Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(Map<String, Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acteurs == null) ? 0 : acteurs.hashCode());
		result = prime * result + ((dateSortie == null) ? 0 : dateSortie.hashCode());
		result = prime * result + duree;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((realisateur == null) ? 0 : realisateur.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Film other = (Film) obj;
		if (acteurs == null) {
			if (other.acteurs != null)
				return false;
		} else if (!acteurs.equals(other.acteurs))
			return false;
		if (dateSortie == null) {
			if (other.dateSortie != null)
				return false;
		} else if (!dateSortie.equals(other.dateSortie))
			return false;
		if (duree != other.duree)
			return false;
		if (id != other.id)
			return false;
		if (realisateur == null) {
			if (other.realisateur != null)
				return false;
		} else if (!realisateur.equals(other.realisateur))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	
	
	
}
