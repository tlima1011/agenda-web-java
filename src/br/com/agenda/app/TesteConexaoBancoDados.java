package br.com.agenda.app;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.agenda.dao.ConnectionFactory;

public class TesteConexaoBancoDados {

	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conectado ao Banco de dados!");
		connection.close();
	}
}
