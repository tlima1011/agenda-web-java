<%@ page import="java.util.*, br.com.agenda.dao.*, br.com.agenda.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eventos</title>
</head>
<body>
	<table cellspacing="2" width="70%"> 
	<thead align="left">
		<tr> 
			<th>Título</th> 
			<th>Descricao</th>   
			<th>Data Evento</th> 
			<th>Data Criação</th>
			<th>Local</th>
		</tr>
	</thead> 
	<% List<Evento> eventos = new EventoDao().getLista(); 
	for (Evento e : eventos) {%> 
	<tr> 
		<td><%=e.getTitulo()%></td> 
		<td><%=e.getDescricao()%></td>  
		<td><%=e.getData_evento().getTime()%></td> 
		<td><%=e.getData_criacao().getTime()%></td>
		<td><%=e.getLocal()%></td>
	</tr> 
	<% } %> 
	</table>
</body>
</html>