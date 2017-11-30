package exceptions;

public class CategoriaInvalida extends Exception{
	private final String message;
	
	public CategoriaInvalida(String message) {
		super(message);
		this.message = message;		
	}
}
