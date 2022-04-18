package com.springrest.prodectapi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class recordnotfoundException extends Exception {
	

public recordnotfoundException() {

}

public recordnotfoundException(String message) {
	super(message);
	
}

}
