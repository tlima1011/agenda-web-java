package br.com.agenda.mvc.servico;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;

public class GravaEventoServico implements Servico{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		String sId = request.getParameter("id"); 
		String titulo = request.getParameter("titulo"); 
		String descricao = request.getParameter("descricao"); 
		String local = request.getParameter("local"); 
		Calendar data_evento = null; 
		Calendar data_criacao = null; 
		try {  
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_evento")); 
			data_evento = Calendar.getInstance(); 
			data_evento.setTime(date); 
			date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_criacao")); 
			data_criacao = Calendar.getInstance(); 
			data_criacao.setTime(date); 
		} catch (RuntimeException e) { 
			throw new ServletException(e); 
		} catch (ParseException e) { 
			throw new ServletException(e); 
		} //Instanciação do Imovel 
		Evento evento = new Evento(titulo, descricao, data_evento, data_criacao, local); 
		//Gravar no BD com o DAO 
		if (sId == null || sId.equals("")) { 
			new EventoDao(connection).adiciona(evento);
		}else { 
			Integer id = Integer.parseInt(sId); 
			evento.setId(id); 
		new EventoDao(connection).altera(evento); 
		} //retorna para o serviço de listar 
		return new ListaEventosServico().executa(request, response);
	}
}
