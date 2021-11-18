<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.com.agenda.dao.*, br.com.agenda.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda</title>
<link href="css/jquery.css" rel="stylesheet"> 
<script src="js/jquery.js"></script> 
<script src="js/jquery-ui.js"></script>
<link rel="shortcut icon" href="imagens/calendario.png" type="image/x-icon">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<h1 align="center">Cadastrar Evento</h1> <hr /> 
	<form action="mvc" method="post" align="center"> 
	<table align="center"> 
		<tr> 
			<td>Tiulo:</td>
			<td><input type="text" name="titulo" value="${evento.titulo}" placeholder="Titulo do evento"/></td> 
		</tr> 
		<tr> 
			<td>Descrição:</td>
			<td><textarea name="descricao" rows="5" cols="23" placeholder="Informe a descrição aqui"/>${evento.descricao}</textarea></td> 
		</tr> 
		<tr> 
			<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
			<fmt:formatDate value="${evento.data_evento.time}" pattern="dd/MM/yyyy" var="dataFmt"/>
			<td>Data Evento:</td>
			<td>
				<custom:campoData id="data_evento" value="${evento.data_evento.time}"/>
			</td> 
		</tr> 
		<tr> 
			<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
			<fmt:formatDate value="${evento.data_criacao.time}" pattern="dd/MM/yyyy" var="dataFmt"/>
			<td>Data Criação:</td>
			<td>
				<custom:campoData id="data_criacao" value="${dataFmt}"/>
			</td> 
		</tr>
		<tr> 
			<td>Local:</td>
			<td>
				<input type="text" name="local" value="${evento.local}" placeholder="Informe o local do Evento"/>
			</td> 
		</tr>
		</table>
		<br/> 
			<input type="hidden" name="id" value="${evento.id}" />
			<input type="hidden" name="servico" value="GravaEventoServico" />
			<button type="submit" class="btn btn-primary" onclick="alert('Agendamento salvo com sucesso!')">Salvar</button> 
			<button type="reset" class="btn btn-primary">Reiniciar</button>
			<a href="mvc?servico=ListaEventosServico"> 
				<button type="button" class="btn btn-primary">Voltar</button>
			</a>
		</form>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>