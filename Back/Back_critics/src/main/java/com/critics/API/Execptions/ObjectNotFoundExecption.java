package com.critics.API.Execptions;

public class ObjectNotFoundExecption extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExecption (String message) {
		super (message);
	}
	
	public ObjectNotFoundExecption (String message, Exception exception) {
		super(message, exception);
	}
	
	public ObjectNotFoundExecption (Exception exception) {
		super(exception);
	} 
}
