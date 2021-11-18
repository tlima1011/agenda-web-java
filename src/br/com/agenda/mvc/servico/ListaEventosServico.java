package br.com.agenda.mvc.servico;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.ConnectionFactory;
import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;

public class ListaEventosServico implements Servico{
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		Connection connection = (Connection) request.getAttribute("conexao"); 
		
		List<Evento> eventos = new EventoDao(connection).getLista(); 
		request.setAttribute("eventos", eventos); 
		return "/WEB-INF/jsp/lista-eventos.jsp";
	}
}
