package br.com.agenda.model;

import java.util.Calendar;
import java.util.Date;

public class Evento {
	
	private int id; 
	private String titulo; 
	private String descricao; 
	private Calendar data_evento; 
	private Calendar data_criacao; 
	private String local; 
	private Usuario usuario; 
	
	public Evento(String titulo, String descricao, Calendar data_evento, Calendar data_criacao, String local) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data_evento = data_evento;
		this.data_criacao = data_criacao;
		this.local = local;
	}

	public Evento() {
		this.id = id; 
		this.titulo = titulo;
		this.descricao = descricao;
		this.data_evento = data_evento;
		this.data_criacao = data_criacao;
		this.usuario = usuario;
		this.local = local; 
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData_evento() {
		return data_evento;
	}

	public void setData_evento(Calendar data_evento) {
		this.data_evento = data_evento;
	}

	public Calendar getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Calendar data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Usuario getUsuario() {
		return usuario;
	}
		
}
