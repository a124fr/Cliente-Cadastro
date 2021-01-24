package curso;

import curso.dao.ClienteDAO;
import curso.dao.DAOFactory;
import curso.dao.modelo.Cliente;

public class BuscaClientePeloCodigo {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();		
		Cliente cliente = clienteDAO.buscarPeloCodigo(1L);
		
		if(cliente.getCodigo() > 0) {
			System.out.println("------ Cliente encontrado ------");
			System.out.printf("Código %d\n", cliente.getCodigo());
			System.out.printf("Nome: %s\n", cliente.getNome());
			System.out.println();
		} else {
			System.out.println("Nenhum cliente encontrado!");
		}
		
	}

}
