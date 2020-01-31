package com.acid.aig.traning.aigtraning.api.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
  public NotFoundException(String message, Throwable t) {
    super(message, t);
  }

  public NotFoundException(String message) {
    super(message);
  }
}