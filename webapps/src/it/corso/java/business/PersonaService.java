package it.corso.java.business;

import javax.ejb.Local;

import it.corso.java.data.Persona;

@Local
public interface PersonaService {
	
	public void inserisci(Persona p);
	public void aggiorna(Persona p);
	public void  cancella(Persona p);
	public Persona getPersonaById(Long id);

}
