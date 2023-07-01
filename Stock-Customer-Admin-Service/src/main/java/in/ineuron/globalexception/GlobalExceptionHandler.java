package in.ineuron.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.exception.AdminDataInsertionException;
import in.ineuron.exception.AdminDataNotFoundException;
import in.ineuron.exception.CustomerDataInsertionException;
import in.ineuron.exception.CustomerDataNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AdminDataInsertionException.class)
	public ResponseEntity<?> adminDataInsertionException(AdminDataInsertionException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AdminDataNotFoundException.class)
	public ResponseEntity<?> adminInfoNotFoundException(AdminDataNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerDataInsertionException.class)
	public ResponseEntity<?> customerDataInsertionException(CustomerDataInsertionException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(CustomerDataNotFoundException.class)
	public ResponseEntity<?> customerInfoNotFoundException(CustomerDataNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> unknownException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
