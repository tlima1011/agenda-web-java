<%@ page import="java.util.*, br.com.agenda.dao.*, br.com.agenda.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retorno do evento</title>
</head>
<body>
	<h5>Código do Evento: ${param.id}</h5> 
	<% Integer id = new Integer(request.getParameter("id")); 
			Evento evento = new EventoDao().busca(id); 
	if (evento != null) { 
	%> 
	<h4>Evento: <%=evento.getTitulo()%></h4> 
	<% } else { %> 
	<h4>Evento não localizado!</h4> 
	<% } %>
</body>
</html>