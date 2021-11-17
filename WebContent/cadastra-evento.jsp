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
</head>
<body>
	<h1>Cadastrar Evento</h1> <hr /> 
	<form action="mvc" method="post"> 
	<table> 
		<tr> 
			<td>Tiulo:</td>
			<td><input type="text" name="titulo" value="${evento.titulo}" placeholder="Titulo do evento"/></td> 
		</tr> 
		<tr> 
			<td>Descrição:</td>
			<td>
			<textarea name="descricao" rows="5" cols="23" value="${evento.descricao}" placeholder="Informe a descrição aqui"/>${evento.descricao}</textarea></td> 
		</tr> 
		<tr> 
			<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
			<fmt:formatDate value="${evento.data_evento.time}" pattern="dd/MM/yyyy" var="dataFmt"/>
			<td>Data Evento:</td>
			<td>
				<custom:campoData id="data_evento" value="${dataFmt}"/>
			</td> 
		</tr> 
		<tr> 
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
			<input type="submit" value="Salvar" onclick="alert('Produto salvo com sucesso!')"/> 
			<input type="reset" value="Reset"/> 
		</form>
</body>
</html>