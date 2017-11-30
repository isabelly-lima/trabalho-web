package exceptions;

public class FornecedorInvalido extends Exception {
	private final String message;
	
	public FornecedorInvalido(String message) {
		super(message);
		this.message = message;		
	}

}
