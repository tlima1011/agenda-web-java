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
	<form action="cadastrarEvento" method="post"> 
	<table> 
		<tr> 
			<td>Tiulo:</td>
			<td><input type="text" name="titulo" placeholder="Titulo do evento"/></td> 
		</tr> 
		<tr> 
			<td>Descrição:</td>
			<td>
			<textarea name="descricao" rows="5" cols="23" placeholder="Informe a descrição aqui"/></textarea></td> 
		</tr> 
		<tr> 
			<td>Data Evento:</td>
			<td>
				<custom:campoData id="data_evento" />
			</td> 
		</tr> 
		<tr> 
			<td>Data Criação:</td>
			<td>
				<custom:campoData id="data_criacao" />
			</td> 
		</tr>
		<tr> 
			<td>Local:</td>
			<td>
				<input type="text" name="local" placeholder="Informe o local do Evento"/>
			</td> 
		</tr>
		</table>
		<br/> 
			<input type="submit" value="Gravar"/> 
			<input type="reset" value="Reset"/> 
		</form>
</body>
</html>