package com.samples.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.samples.response.ApiResponse;

@RestControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error ->{
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.builder().message(exception.getMessage()).status(HttpStatus.NOT_FOUND).build());		
	}
	public ResponseEntity<ApiResponse> handleUserNamenotFoundException(UserNamenotFoundException exception){
		return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(ApiResponse.builder().message(exception.getMessage()).status(HttpStatus.NOT_FOUND).build());
	}
}
