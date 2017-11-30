package exceptions;

public class CategoriaInvalida extends Exception{
	private String message;
	
	public CategoriaInvalida(String message) {
		super(message);
		this.message = message;		
	}
}
