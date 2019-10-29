package fr.gtm.films.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * 
 * DAO abstrait
 * 	implémentaion d'un CRUD de base
 * 	E  : type de l'entité
 *  ID : type de l'identifiant de l'entité
 */
public abstract class AbstractDAO<E,ID> {
	private EntityManagerFactory emf;
	private Class<E> entityClass;

	public AbstractDAO(EntityManagerFactory emf,Class<E> entityClass) {
		this.entityClass = entityClass;
		this.emf = emf;
	}
	
	/**
	 * 
	 * @return l'instance de EntityManagerFactory
	 */
	protected EntityManagerFactory getEMF() {
		return emf;
	}
	
	public void create(E entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public E findById(ID id) {
		EntityManager em = emf.createEntityManager();
		E entity = em.find(entityClass, id);		
		em.close();
		return entity;
	}
	
	public void delete(ID id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		E entity = em.find(entityClass, id);
		if(entity != null)
			em.remove(entity);
		em.getTransaction().commit();
		em.close();	
	}
	
	public void update(E entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();	
	}

}
