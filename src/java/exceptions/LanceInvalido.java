package exceptions;

public class LanceInvalido extends Exception {
	private final String message;
	
	public LanceInvalido(String message) {
		super(message);
		this.message = message;		
	}
}
