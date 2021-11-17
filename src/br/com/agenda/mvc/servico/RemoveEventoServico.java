package br.com.agenda.mvc.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;

public class RemoveEventoServico implements Servico{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		Integer id = Integer.parseInt(request.getParameter("id")); 
		Evento evento = new Evento(); 
		evento.setId(id); 
		System.out.println("Excluindo o evento..."); 
		new EventoDao().remove(evento);
		return "lista-eventos.jsp"; 
	}
}
