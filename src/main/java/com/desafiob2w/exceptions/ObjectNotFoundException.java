package com.desafiob2w.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4470197452732957497L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
}
