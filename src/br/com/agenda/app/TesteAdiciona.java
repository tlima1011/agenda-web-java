package br.com.agenda.app;

import java.util.Calendar;

import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;
import br.com.agenda.model.Login;

public class TesteAdiciona {

	public static void main(String[] args) {
		
		Login l = new Login(); 
		l.setId(1);
		l.setLogin("ze");
		l.setSenha("1234");
		
		Evento evento = new Evento(); 
		evento.setTitulo("Agendamento");  
		evento.setDescricao("Agenda em algum lugar sabe la onde"); 
		evento.setData_evento(Calendar.getInstance());
		evento.setData_criacao(Calendar.getInstance());
		evento.setLocal("Sao Paulo");
		new EventoDao().adiciona(evento); 
		System.out.println("Salvo no BD.");
	}
}
