package exceptions;

public class ProdutoInvalido extends Exception{
	private String message;
	
	public ProdutoInvalido(String message) {
		super(message);
		this.message = message;		
	}
}
