<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda</title>
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
				<input type="text" name="data_evento"/>
			</td> 
		</tr> 
		<tr> 
			<td>Data Criação:</td>
			<td>
				<input type="text" name="data_criacao"/>
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