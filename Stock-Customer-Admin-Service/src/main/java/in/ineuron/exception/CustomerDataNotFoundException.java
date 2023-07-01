package in.ineuron.exception;

public class CustomerDataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerDataNotFoundException(String message) {
		super(message);
	}

}
