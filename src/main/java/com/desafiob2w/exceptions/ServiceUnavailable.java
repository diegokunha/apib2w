package com.desafiob2w.exceptions;

public class ServiceUnavailable extends RuntimeException {

	private static final long serialVersionUID = 8566688952430995268L;

	public ServiceUnavailable(String msg) {
		super(msg);
	}
	
}
