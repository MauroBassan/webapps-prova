<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.time.*" %>
<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 

 <%@ page errorPage="error.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		
		
			<ul>
				<li><a href="">Menu1</a>
				<li><a href="">Menu2</a>
			</ul>
		
		<c:out value="PROVA DI CONFIGURAZIONE!!!"></c:out>
		<c:out value="<%=request.getParameter(\"test\") %>" default="ECCO!"></c:out>
		<!--  altro modo senza scriptlet: -->
		<c:out value="${param.testing}" default="ECCOCI!"></c:out>
		
		<c:set var="prova" value="1234" scope="request"></c:set>
		<c:out value="${prova}" default="CI SIAMO"></c:out>
		
		<h2>${prova}</h2>
		
		<hr>
		
		<%	//creo lista con codice java quindi senza jstl
			List<String> lista = new ArrayList<String>();
			lista.add("valore1");
			lista.add("valore2");
			lista.add("valore3");
			
			for (String s : lista) {
				out.println(s + "<br");
			}
			
			request.setAttribute("elementi", lista);
		%>
			
			<hr>
			<!-- ora invece creo lista con codice jstl -->
			
			<c:forEach items="${requestScope.elementi}" var="elemento" varStatus="contatore">
				${elemento} - ${contatore.count}<br>
			</c:forEach>
			
			<c:forTokens items="1,2,3,4,5" delims="," var="numero" varStatus="contatore">
				${numero}
			</c:forTokens>
					
			<hr>
			
			<%
				Calendar c = new GregorianCalendar();
				c.set(Calendar.YEAR, 2020);
				c.set(Calendar.MONTH, 4);
				c.set(Calendar.DATE, 4);
				
				request.setAttribute("dataCorrente", c.getTime());
			%>
			
			<fmt:formatDate value="${requestScope.dataCorrente}" pattern="d/M/y" var="data"/>
			
			<p> DATA FORMATTATA ${data}</p>
					
			
	</header>