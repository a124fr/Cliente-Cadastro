package curso.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import curso.dao.ClienteDAO;
import curso.dao.DAOFactory;

public class JdbcDAOFactory extends DAOFactory {
	
	private Connection connection;
	
	public JdbcDAOFactory() {
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro_cliente", 
					"root", "");			
		} catch(Exception e) {
			throw new RuntimeException("Erro recuperando conexção com banco.", e);
		}
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new JdbcClienteDAO(connection);
	}
	
}
