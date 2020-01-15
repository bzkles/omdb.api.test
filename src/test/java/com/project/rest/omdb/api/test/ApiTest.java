package com.project.rest.omdb.api.test;

import java.util.Properties;

import org.junit.Test;
//import com.project.rest.omdb.api.test.ApiURI;

public class ApiTest extends ApiURI {
	
	
	public  String search = "Harry Potter";    
	public  String sampleTitle="Harry Potter and the Sorcerer's Stone";
	
	@Test
	public void searchAssertion() {
		
		Method_ApiTest api = new Method_ApiTest();
		
	    String id = api.searchWithTitle(baseURI,apiKey,search,sampleTitle);

	    api.searchWithId();
	    
	}

}
