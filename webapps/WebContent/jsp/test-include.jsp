<%@ include file="header.jsp" %>


<div>
	<h1> SONO UNA JSP!</h1>

	<jsp:useBean id="articoloSelezionato" class="it.corso.java.web.bean.Articolo" scope="request"></jsp:useBean>
	
	<p>
		<%
		articoloSelezionato.getNome();
		%>
	</p>
	
</div>
<%@ include file="footer.jsp" %>
