package in.ineuron.globalhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.exception.StockInfoInsertionException;
import in.ineuron.exception.StockNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = StockNotFoundException.class)
	public ResponseEntity<?> handleCompanyNotFoundException(StockNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = StockInfoInsertionException.class)
	public ResponseEntity<?> handleCompanyInsertionException(StockInfoInsertionException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> unknownException(Exception e) {
		String msg = "Unknown Exception Pleasse try after some time " + e.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
