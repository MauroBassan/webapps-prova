package it.corso.java.business;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.corso.java.data.Cliente;
import it.corso.java.data.ContoCorrente;
import it.corso.java.data.Fattura;
import it.corso.java.data.Utente;



/**
 * (Session Bean implementation class CorsoWebBean)
 * abbiamo detto che il nostro session bean implementa 2 interfacce, quindi
 * il client che vuole accedere al metodo saluto,
 * dovrà accedere a una interfaccia locale o remota
 */
@Stateless
/*
 * @Interceptors({CorsoWebInterceptor.class})
 */
public class CorsoWebBean implements CorsoWebLocal, CorsoWebRemote {
	
	@PersistenceContext(unitName = "corsoWebPersistence")
	EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public CorsoWebBean() {
        
    }
    
    public void salvaFattura() {
    	Fattura f = new Fattura();
    	f.setDataFattura(new Date());
    	f.setNumeroFattura("5678");
    	
    	Cliente c = new Cliente();
    	c.setCognome("Bsn");
    	c.setNome("Mro");
    	
    	f.setCliente(c);
    	manager.persist(f);
    }
    
    public String saluto() {
    	return "ciao sono un EJB";
    }
    
    public void stampaFattura() {
    	Fattura f = manager.find(Fattura.class, 1);
    	
    	f.getCliente().getNome();
    	
    }
    
    public void collegati() {
    	
    }
    
    public void creaContoAssociatoAdUnUtente() {
    	
    	Utente u = manager.find(Utente.class, 2);
    	
    	ContoCorrente c3 = new ContoCorrente();
    	c3.setNumero("2222");
    	c3.setUtenteConto(u);
    	u.getConti().add(c3);
    	
    }
    
    public void creaConto() {
    	Utente u = new Utente();
    	u.setCognome("Pincho");
    	u.setNome("Pancho");
    	
    	ContoCorrente c1 = new ContoCorrente();
    	c1.setNumero("5555");
    	c1.setUtenteConto(u);
    	
    	
//    	Utente u = new Utente();
//    	u.setCognome("Rossi");
//    	u.setNome("Mauro");
//    	u.setConti(new ArrayList<ContoCorrente>());
//    	
//    	ContoCorrente c1 = new ContoCorrente();
//    	c1.setNumero("1234");
//    	c1.setUtenteConto(u);
//    	u.getConti().add(c1);
//    	
//    	ContoCorrente c2 = new ContoCorrente();
//    	c2.setNumero("5678");
//    	c2.setUtenteConto(u);
//    	u.getConti().add(c2);
//    	
    	manager.persist(c1);
    }
    
}
