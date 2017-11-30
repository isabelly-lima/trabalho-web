package exceptions;

public class PedidoInvalidoException extends Exception {
	private String message;
	
	public PedidoInvalidoException(String message) {
		super(message);
		this.message = message;
	}
}
