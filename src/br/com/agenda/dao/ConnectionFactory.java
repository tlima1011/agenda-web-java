package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/agenda";
		String usuario = "root";
		String senha = "";

		try {
			Class.forName("com.mysql.jdbc.Driver"); //Driver para Tomcat 9 
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException | ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}
}
