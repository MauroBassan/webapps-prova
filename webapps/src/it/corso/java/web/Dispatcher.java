package it.corso.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corso.java.business.CorsoWebLocal;
import it.corso.java.business.CorsoWebRemote;
import it.corso.java.business.CorsoWebStatefulBeanLocal;
import it.corso.java.web.bean.Articolo;

/**
 * Servlet implementation class Dispatcher
 */
@WebServlet("/web")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB // creo una istanza della interfaccia local che punta al nostro ejb,attraverso la dep injection effettua il recupero dell'oggetto associato all'ejb,  cercandolo nel jndi
	CorsoWebLocal corsoLocal;
	
	@EJB
	CorsoWebRemote corsoRemote;
	
	@EJB
	CorsoWebStatefulBeanLocal corsoStateful;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dispatcher() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		corsoLocal.creaContoAssociatoAdUnUtente();
		
		//corsoLocal.creaConto();
		//PrintWriter out = response.getWriter();
		String saluto = corsoLocal.saluto();
		
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		
		//response.sendError(404);
		
		//corsoLocal.salvaFattura();
		
		//corsoLocal.stampaFattura();
		
		String pagina = request.getParameter("pagina");
		if(pagina != null && !pagina.trim().equals("")) {
			if(pagina.equals("1")) {
				request.setAttribute("oggetto", "test");
				
				// associamo alla variabile carrello, l'ipotetico carrello presente in memoria
				// prendiamo l'oggetto dalla sessione
				List<String> carrello = (List<String>) request.getSession().getAttribute("carello");
				if(carrello == null) {
					// se non c'è lo creiamo
					carrello = new ArrayList<String>();
					request.getSession().setAttribute("carrello", carrello);
					
				}
				// e aggiungiamo l'articolo
				String articolo = request.getParameter("articolo");
				if(articolo != null && !articolo.trim().equals("")) {
					carrello.add(articolo);
				}
				
				carrello.add("saluto dell'EJB: " + saluto);
				
				carrello.add("saluto dell'EJB REMOTO: " + corsoRemote.saluto());
				request.removeAttribute("oggetto");
				
				//ogni volta che chiamo la pagina 1 incremento la variabile contatore di statful
				corsoStateful.incrementa(1);
				System.out.println(corsoStateful.getContatore());
				
				corsoStateful.chiudiConnessione();
				
				request.getServletContext().getRequestDispatcher("/jsp/pagina1.jsp").include(request, response) ;
			} else if(pagina.equals("2")) {
				
				Articolo art = new Articolo();
				art.setCodice("123");
				art.setNome("gioco da tavolo");
				art.setPrezzo(40);
				
				request.setAttribute("articolo", art);
				
				request.getServletContext().getRequestDispatcher("/jsp/pagina2.jsp").include(request, response) ;
			} else if(pagina.equals("3")) {
				request.getServletContext().getRequestDispatcher("/jsp/pagina3.jsp").include(request, response) ;
			} else {
				request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request, response);
			}
		} else {
			
		request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request, response);
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
