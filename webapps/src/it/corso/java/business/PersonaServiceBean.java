package it.corso.java.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.corso.java.data.Persona;

/**
 * Session Bean implementation class PersonaServiceBean
 */
@Stateless
public class PersonaServiceBean implements PersonaServiceBeanRemote, PersonaServiceBeanLocal {
	
	@PersistenceContext(unitName = "corsoWebPersistence")
	EntityManager manager;

	/**
	 * Default constructor. 
	 */
	public PersonaServiceBean() {

	}

	public void inserisci(Persona p) {
		manager.persist(p);
	}

	public void aggiorna(Persona p) {
		manager.merge(p);
	}
	
	public void cancella(Persona p) {
    	manager.remove(p);
    }

	public Persona getPersonaById(Long id) {
		
		return manager.find(Persona.class, id);
	}
}
