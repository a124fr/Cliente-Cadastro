package curso.dao;

public class DAOException extends RuntimeException {
		
	public DAOException(String msg, Throwable e) {
		super(msg, e);
	}
}
