package br.com.agenda.mvc.servico;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;

public class MostraEventoServico implements Servico {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		String parametro = request.getParameter("id");
		if (parametro != null) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Buscando o imóvel...");
			Evento evento = new EventoDao(connection).busca(id);
			request.setAttribute("evento", evento);
		}
		return "/WEB-INF/jsp/cadastra-evento.jsp";
	}
}
