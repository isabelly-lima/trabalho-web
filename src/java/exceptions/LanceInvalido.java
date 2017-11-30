package exceptions;

public class LanceInvalido extends Exception {
	private String message;
	
	public LanceInvalido(String message) {
		super(message);
		this.message = message;		
	}
}
