package br.com.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;

@WebServlet("/cadastrarEvento")
public class CadastraEventoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String local = request.getParameter("local");
		Calendar data_evento = null;
		Calendar data_criacao = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(request.getParameter("data_evento"));
			data_evento = Calendar.getInstance();
			data_evento.setTime(date);
			date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(request.getParameter("data_criacao"));
			data_criacao = Calendar.getInstance();
			data_criacao.setTime(date);
		} catch (ParseException e) {
//			out.println("Erro de conversão de data e hora use (dd/MM/YYYY HH:mm)");
//			return;
			throw new ServletException(e);
		} 
		// Instanciação do Evento 	
		Evento evento = new Evento(titulo, descricao, data_evento, data_criacao, local); // Gravar no BD com o DAO
		new EventoDao().adiciona(evento);
		// Resposta para o cliente
		out.println("<html><body><h3>");
		out.println("Evento: " + evento.getTitulo() + " cadastrado com sucesso!");
		out.println("</h3></body></html>");
	}// fim service

}
