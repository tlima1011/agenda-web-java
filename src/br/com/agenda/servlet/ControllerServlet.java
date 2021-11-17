package br.com.agenda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.mvc.servico.Servico;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = request.getParameter("servico"); 
		String nomeDaClasse = "br.com.agenda.mvc.servico." + parametro; 
		try { 
			Servico servico = (Servico) Class.forName(nomeDaClasse).newInstance(); 
			String pagina = servico.executa(request, response); 
			RequestDispatcher rq = request.getRequestDispatcher(pagina); 
			rq.forward(request, response); } catch (Exception ex) { 
				throw new ServletException("Erro na execução do serviço. ", ex); 
			}// fim try 
		}// fim service
	}

