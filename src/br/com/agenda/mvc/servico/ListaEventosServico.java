package br.com.agenda.mvc.servico;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;

public class ListaEventosServico implements Servico{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Evento> eventos = new EventoDao().getLista(); 
		request.setAttribute("eventos", eventos); 
		return "lista-eventos.jsp";
	}
}
