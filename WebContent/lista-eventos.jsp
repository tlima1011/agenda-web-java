<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.com.agenda.dao.*, br.com.agenda.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eventos</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<table cellspacing="2" width="70%" align="center" font-size="24"> 
	<thead align="left">
		<tr bgcolor="#${ln.count % 2 == 0 ? 'cfcfc4' : 'ffffff'}"> 
			<th>Titulo</th> 
			<th>Descricao</th> 		 
			<th>Data Evento</th> 
			<th>Data Criação</th>
			<th>Local</th>
		</tr>
	</thead> 
	
	<jsp:useBean id="dao" class="br.com.agenda.dao.EventoDao" /> 
	<c:forEach var="evento" items="${dao.lista}" varStatus="ln" > 
	<tr bgcolor="#${ln.count % 2 == 0 ? 'dcdcdc' : 'ffffff'}"> 
		<td>${evento.titulo}</td> 
		<td>${evento.descricao}</td> 
		<td><fmt:formatDate value="${evento.data_evento.time}" pattern="dd/MM/yyyy"/></td>
		<td><fmt:formatDate value="${evento.data_criacao.time}" pattern="dd/MM/yyyy"/></td> 
		<td>${evento.local}</td> 
		<td> <a href="mvc?servico=RemoveEventoServico&id=${evento.id}">Remover</a> </td>
	</tr> 
	</c:forEach> 
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>