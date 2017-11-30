package exceptions;

public class FornecedorInvalido extends Exception {
	private String message;
	
	public FornecedorInvalido(String message) {
		super(message);
		this.message = message;		
	}

}
