package curso;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import curso.dao.ClienteDAO;
import curso.dao.DAOFactory;
import curso.dao.modelo.Cliente;

public class SalvaCliente {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				
		Cliente cliente = new Cliente();
		
		String nome = JOptionPane.showInputDialog(null, "Nome do cliente"
				, "Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
		
		if(nome != null && !nome.isEmpty()) {
			cliente.setNome(nome);
			ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();		
			clienteDAO.salvar(cliente);		
			System.out.println("Cliente Salvo com Sucesso!");
			
			JOptionPane.showMessageDialog(null, "Cliente Salvo com Sucesso!", "Mensagem de Sucesso", JOptionPane.PLAIN_MESSAGE, null);
		}
	}

}
