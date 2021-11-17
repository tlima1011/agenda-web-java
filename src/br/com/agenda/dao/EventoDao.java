package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.agenda.model.Evento;
import br.com.agenda.model.Login;

public class EventoDao {

	private Login login;

	private Connection connection;

	Login l = new Login();

	public EventoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Evento evento) {
		String sql = "insert into evento (titulo, descricao, data_evento, data_criacao, local) values (?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, evento.getTitulo());
			stmt.setString(2, evento.getDescricao());
			stmt.setDate(3, new Date(evento.getData_evento().getTimeInMillis()));
			stmt.setDate(4, new Date(evento.getData_criacao().getTimeInMillis()));
			stmt.setString(5, evento.getLocal());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} // fim try
	}// fim adiciona

	public List<Evento> getLista() {
		String sql = "select * from evento";
		List<Evento> eventos = new ArrayList();
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Evento evento = new Evento();
				evento.setId(rs.getInt("id"));
				evento.setTitulo(rs.getString("titulo"));
				evento.setDescricao(rs.getString("descricao"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_evento"));
				evento.setData_evento(data);
				data.setTime(rs.getDate("data_criacao"));
				evento.setData_criacao(data);
				evento.setLocal(rs.getString("local"));
				eventos.add(evento);
			} // fim while
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} // fim try
		return eventos;
	}// fim lista

	public Evento busca(Integer id) {
		String sql = "select * from agenda where id = ?";
		Evento evento = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				evento = new Evento();
				evento.setId(rs.getInt("id"));
				evento.setTitulo(rs.getString("titulo"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_evento"));
				evento.setData_evento(data);
				data.setTime(rs.getDate("data_criacao"));
				evento.setData_criacao(data);
				evento.setLocal(rs.getString("local"));
			} // fim if
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} // fim try
		return evento;
	}// fim busca

	public void altera(Evento evento) {
		String sql = "update evento set titulo = ?, descricao = ?, data_evento = ?, data_criacao = ?, local = ? where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, evento.getTitulo());
			stmt.setString(2, evento.getDescricao());
			stmt.setDate(3, new Date(evento.getData_evento().getTimeInMillis()));
			stmt.setDate(4, new Date(evento.getData_criacao().getTimeInMillis()));
			stmt.setString(5, evento.getLocal());
			stmt.setLong(6, evento.getId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} // fim try
	}// fim altera

	public void remove(Evento evento) {
		String sql = "delete from evento where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, evento.getId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} // fim try
	} // fim remove
}
