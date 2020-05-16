package it.corso.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * Servlet implementation class DownloadPdf
 */
@WebServlet("/downloadpdf")
public class DownloadPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadPdf() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// creiamo un oggetto di tipo pdfwriter e specifichiamo l'outputstream che prendiamo dalla response, tutto lo stream del pdf va a finire dentro l'output
		PdfWriter pdf = new PdfWriter(response.getOutputStream());
		
		//ora inizializziamo un oggetto di tipo pdf a cui passiamo in ingresso il writer
		PdfDocument doc = new PdfDocument(pdf);
		
		// ora creiamo un oggetto document che servirà per aggiungere tutti gli elementi nel pdf(immagini, elementi, paragrafi)
		Document document = new Document(doc);
		document.add(new Paragraph("Sono un file pdf!"));
		document.add(new Paragraph("Sono un file pdf!"));
		document.add(new Paragraph("Sono un file pdf!"));
		document.add(new Paragraph("Sono un file pdf!"));
		document.add(new Paragraph("Sono un file pdf!"));
		
		document.close();
		
		// ora inviamo il documento
		response.setContentType("application/pdf");
		// aggiungiamo nell'header una content-disposition, stiamo dicendo che il file deve essere scaricato
		response.setHeader("Content-disposition", "attachment; filename=corsojava.pdf");
		
		
//		String nome = request.getParameter("nome");
//		String cognome = request.getParameter("cognome");
//		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head><title>Ciao</title></head>");
//		out.println("<body>");
//		out.println("<h1>Ciao " + nome + " "+ cognome + "</h1>" );
//		out.println("</body>");
//		out.println("</html>");
		
//		azioni(request, response);
//		
//		response.addCookie(new Cookie("corso-web", "success"));
//		
//		response.getWriter().append((String)request.getAttribute("nomeAttributo"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		//azioni(request, response);
				
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Ciao</title></head>");
		out.println("<body>");
		out.println("<h1>Ciao " + nome + " "+ cognome + "</h1>" );
		out.println("<p>Sono nel doPost</p>" );
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
	
	private void azioni(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.getWriter().append("\n Method: " + request.getMethod());
		
		response.getWriter().append("\n Context: " + request.getContextPath());
		
		//response.getWriter().append("\n User-Agent: " + request.getHeader("user-agent"));
		
		//Enumeration<String> en = request.getHeaderNames();
		
//		while(en.hasMoreElements()) {
//			
//			String element = en.nextElement();
//			response.getWriter().append("\n - " +element +": " + request.getHeader(element));
//		}
//		
		response.getWriter().append("\n parametro: " + request.getParameter("prova")); // recupera i valori dei parametri k,v, esempio URL... nome1=pippo , ritorna pippo: nome1 è il parametro, pippo è il valore
		
		String[] params = request.getParameterValues("");
		if(params != null) {
			for (String string : params) {
				response.getWriter().append("parametro = " +  string);
				
			}
		}
		//request.setAttribute("nomeAttributo", "valore prova");
	}

	@Override
	public void init() throws ServletException {
		/* istanziare connessio al db */
		/* verificare che i REST web services da invocare rispondono correttamente */
		super.init();
	}

	@Override
	public void destroy() {
		/* chiusura connessione al DB o ai serivizi o scrittura eventuali log ecc*/
		super.destroy();
	}

	
	
}
