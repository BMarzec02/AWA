package kurier.DAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kurier.entities.Przesylki;

@Stateless
public class PrzesylkiDAO {

	@PersistenceContext
	EntityManager em;
	
	public void create(Przesylki przesylka) {
		em.persist(przesylka);
	}

	public Przesylki merge(Przesylki przesylka) {
		return em.merge(przesylka);
	}

	public void remove(Przesylki przesylka) {
		em.remove(em.merge(przesylka));
	}

	public Przesylki find(Object id) {
		return em.find(Przesylki.class, id);
	}
}
