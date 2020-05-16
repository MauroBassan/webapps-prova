package it.corso.java.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corso.java.business.PersonaServiceBeanLocal;
import it.corso.java.data.Account;
import it.corso.java.data.Persona;

/**
 * Servlet implementation class Persona
 */
@WebServlet("/persona")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@EJB
	PersonaServiceBeanLocal personaService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method") != null ? request.getParameter("method"): "";
		
		if(method.equals("add")) {
			Persona p = new Persona();
			
			p.setNome("");
			p.setCognome("");
			p.setAnni(0);
			
			Account a = new Account();
			a.setPassword("0000");
			a.setUsername("mmm");
			
			p.setAccount(a);
			personaService.inserisci(p);
			
		} else if(method.equals("get")) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			
			Persona p =personaService.getPersonaById(id);
			
			response.getWriter().println(p.getCognome()+" " + p.getNome());
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
