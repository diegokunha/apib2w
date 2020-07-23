package com.desafiob2w.ws;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.desafiob2w.domains.ResultApiSW;

public class RestSWAPTest {

	@Autowired
	private RestSWAP restTest;
	
	@Before
	public void init() {
		this.restTest = new RestSWAP();
	}
	
	@Test
	public void testaAparicoes() {
		ResponseEntity<ResultApiSW> result = restTest.RetornaAparicoes();
    	Assert.assertNotNull(result);
     }
	
}
