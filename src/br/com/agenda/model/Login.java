package br.com.agenda.model;

import java.util.ArrayList;

public class Login {
	
	private int id; 
	private String login; 
	private String senha;
	
	private ArrayList <Evento> eventos = new ArrayList<>(); 
		
	public Login() { 
		
	}
	
	public Login(String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	public Login(int id, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void addEvento(Evento e) { 
		eventos.add(e);
	}
	
	public void removeEvento(Evento e) { 
		eventos.remove(e); 
	}

	
}
