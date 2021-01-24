package curso;

import java.util.List;

import curso.dao.ClienteDAO;
import curso.dao.DAOFactory;
import curso.dao.modelo.Cliente;

public class BuscaTodosClientes {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
		
		List<Cliente> clientes = clienteDAO.buscarTodos();
		
		for(Cliente cliente : clientes) {
			System.out.println("------ Cliente encontrado ------");
			System.out.printf("Código %d\n", cliente.getCodigo());
			System.out.printf("Nome: %s\n", cliente.getNome());
			System.out.println();
		}
	}

}
