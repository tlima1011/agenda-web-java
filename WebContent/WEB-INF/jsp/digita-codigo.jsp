<%@ page import="java.util.*, br.com.agenda.dao.*, br.com.agenda.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informe o Código</title>
</head>
<body>
	<form action="busca-evento.jsp" method="post" > 
		Digite o código do evento: 
		<input type="text" name="id" /> 
		<br/>
		<br/> 
		<input type="submit" value="Buscar" />
		<input type="reset" value="Reiniciar" />
	</form>
</body>
</html>