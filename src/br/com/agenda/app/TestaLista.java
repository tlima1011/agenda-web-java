package br.com.agenda.app;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.agenda.dao.EventoDao;
import br.com.agenda.model.Evento;

public class TestaLista {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		List<Evento> eventos = new EventoDao().getLista(); 
		System.out.println("Lista de Eventos:\n"); 
		eventos.forEach(i -> System.out.println(i.getId() 
				+ " - " + i.getTitulo()));
	}
}
