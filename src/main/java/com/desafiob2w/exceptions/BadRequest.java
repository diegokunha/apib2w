package com.desafiob2w.exceptions;

public class BadRequest extends RuntimeException {

	private static final long serialVersionUID = -1373878156076419109L;
	
	public BadRequest(String msg) {
		super(msg);
	}

}
