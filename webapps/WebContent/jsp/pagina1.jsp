<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="javax.servlet.http.HttpSession"%>
<%@ page import ="javax.servlet.http.HttpServletRequest" %>
<%@ page import ="javax.servlet.http.HttpServletResponse" %>
<%@ page import ="javax.servlet.jsp.HttpJspPage" %>

<h1>Titolo pagina 1</h1>
<p>

<b><%= request.getParameter("test") != null ? "TEST C'E!" : "NOOOOOOO" %></b>
<%
	List<String> carrello = (List<String>) request.getSession().getAttribute("carrello");

	if(carrello != null && carrello.size() > 0) {
		for(String articolo : carrello) {
			out.println(articolo +"<br>");
		}
	} else {
		out.println("Non ci sono articoli nel carrello");
	}
%>
</p>