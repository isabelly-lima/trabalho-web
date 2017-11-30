package exceptions;

public class PessoaInvalida extends Exception {
	private final String message;
	
		public PessoaInvalida(String message) {
			super(message);
			this.message = message;
		}

}
