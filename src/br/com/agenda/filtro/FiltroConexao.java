package br.com.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.agenda.dao.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		try {
			Connection connection = new ConnectionFactory().getConnection();
			// adiciona a conexão no request
			request.setAttribute("conexao", connection);
			filterChain.doFilter(request, response);
			connection.close();
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} // fim try/catch
	}// fim doFilter

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}
}
