<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<form action="<%=request.getContextPath()+"/downloadpdf" %>" method="get">
		<label for="nome">Nome</label> 
		<input type="text" name="nome" value="">
		<br> 
		<label for="cognome">Cognome</label> 
		<input type="text" name="cognome" value=""> 
		<br>
		<button type="submit" name="invia">Invia</button>
	</form>
	<hr>
	<form action="<%=request.getContextPath()+"/downloadpdf" %>" method="post">
		<label for="nome">Nome</label> 
		<input type="text" name="nome" value="">
		<br> 
		<label for="cognome">Cognome</label> 
		<input type="text" name="cognome" value=""> 
		<br>
		<button type="submit" name="invia">Invia</button>
	</form>
	

</body>
</html>