package kurier.DAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kurier.entities.Uzytkownicy;

@Stateless
public class UzytkownicyDAO {

	@PersistenceContext
	EntityManager em;
	
	public void create(Uzytkownicy user) {
		em.persist(user);
	}

	public Uzytkownicy merge(Uzytkownicy user) {
		return em.merge(user);
	}

	public void remove(Uzytkownicy user) {
		em.remove(em.merge(user));
	}

	public Uzytkownicy find(Object id) {
		return em.find(Uzytkownicy.class, id);
	}
}
