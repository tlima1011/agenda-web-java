package br.com.agenda.mvc.servico;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;

public class RemoveEventoServico implements Servico{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		Integer id = Integer.parseInt(request.getParameter("id")); 
		Evento evento = new Evento(); 
		evento.setId(id); 
		System.out.println("Excluindo o evento..."); 
		new EventoDao(connection).remove(evento);
		return "/WEB-INF/jsp/lista-eventos.jsp"; 
	}
}
