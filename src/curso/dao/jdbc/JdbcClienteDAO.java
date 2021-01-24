package curso.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import curso.dao.ClienteDAO;
import curso.dao.DAOException;
import curso.dao.modelo.Cliente;

public class JdbcClienteDAO implements ClienteDAO {

	private Connection connection;
	
	public JdbcClienteDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void salvar(Cliente cliente) {
		try {
			//String sql = String.format("INSERT INTO cliente(nome)VALUAES('%S')", cliente.getNome());
			String sql = String.format("INSERT INTO cliente(nome)VALUES(?)");			
			java.sql.PreparedStatement ps = this.connection.prepareStatement(sql);			
			ps.setString(1, cliente.getNome());
			ps.execute();			
		} catch(SQLException e) {
			throw new DAOException("Erro ao Salvar o cliente!", e);
		} finally {		
			try {
				if(!this.connection.isClosed()) {
					this.connection.close();
				}
			}catch(Exception e) {}
		}
	}

	@Override
	public Cliente buscarPeloCodigo(Long codigo) {
		Cliente cliente = new Cliente();
		
		try {			
			String sql = String.format("SELECT * FROM cliente WHERE codigo = ?");			
			java.sql.PreparedStatement ps = this.connection.prepareStatement(sql);			
			ps.setLong(1, codigo);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
			}
			
		} catch(SQLException e) {
			throw new DAOException("Erro buscando cliente!", e);
		} finally {		
			try {
				if(!this.connection.isClosed()) {
					this.connection.close();
				}
			}catch(Exception e) {}
		}
		
		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente>  clientes = new ArrayList<Cliente>();
		
		try {			
			String sql = String.format("SELECT * FROM cliente");			
			java.sql.PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
				
				clientes.add(cliente);
			}
			
		} catch(SQLException e) {
			throw new DAOException("Erro buscando lista de clientes!", e);
		} finally {		
			try {
				if(!this.connection.isClosed()) {
					this.connection.close();
				}
			}catch(Exception e) {}
		}
		
		return clientes;
	}
	
}
