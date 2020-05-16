<h1>Titolo pagina 2</h1>

<jsp:useBean id="articolo" class="it.corso.java.web.bean.Articolo" scope="request"></jsp:useBean>


<h2> <%=articolo.getNome() %></h2>
<p>
	<%=articolo.getCodice() %><br>
	<%=articolo.getPrezzo() %>
</p>

<jsp:setProperty name="articolo" property="prezzo" value="600"/>

<h3><%=articolo.getNome() %></h3>
<p>
	<%=articolo.getCodice() %><br>
	<%=articolo.getPrezzo() %>
</p>
<hr>

<!-- proviamo impostando il valore degli attributi tramite il metodo jsp:getProperty -->

<h3><jsp:getProperty name="articolo" property="nome"/></h3>
<p>
	<jsp:getProperty name="articolo" property="codice"/><br>
	<jsp:getProperty name="articolo" property="prezzo"/>
</p>

<%@ include file="footer.jsp" %>