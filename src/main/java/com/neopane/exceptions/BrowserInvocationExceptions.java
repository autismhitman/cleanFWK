package com.neopane.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationExceptions extends RuntimeException {
	
    public BrowserInvocationExceptions(String message) {
        super(message);
    }

  
    public BrowserInvocationExceptions(String message, Throwable cause) {
        super(message, cause);
    }


}
