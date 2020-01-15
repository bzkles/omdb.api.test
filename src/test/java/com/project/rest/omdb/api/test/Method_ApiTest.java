package com.project.rest.omdb.api.test;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import com.project.rest.omdb.api.test.ContentMovie;
import com.jayway.restassured.RestAssured;

import com.jayway.restassured.response.ResponseBody;
import com.project.rest.omdb.api.test.ApiTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import static org.junit.Assert.assertThat;

import java.util.List;


public  class Method_ApiTest extends ApiURI{

	 static String request = "/?s="+"search"+"&apikey="+apiKey;
	 static String request1= "/?i="+"id"+"&apikey="+apiKey;
	
	
	public String  searchWithTitle(String baseURI, String apiKey, String search, String sampleTitle) {
        RestAssured.baseURI = baseURI;

		String id=null;

		try {
			Response response = given()
	                .when()
	                .get(request)
	                .then()
	                .log()
	                .all()
	                .contentType(ContentType.JSON)
	                .statusCode(200)
	                .and()
	                .extract()
		            .response();
			
			JsonPath jsonPath = response.jsonPath();
			List<ContentMovie> data = jsonPath.getList("Search", ContentMovie.class);
            //System.out.println(data.size());

			/* JSONParser parser = new JSONParser();
			 String resp = response.asString();
			 JSONObject json =  (JSONObject) parser.parse(resp);
			 String Search = ((String)json.get("imdbID"));*/
			
			
			
		        ApiTest TestSimple = new ApiTest();
		        
		        for (ContentMovie requests : data) {
					if(requests.getTitle().equals(TestSimple.sampleTitle)) {
		                 id = requests.getImdbID();
						System.out.println("\n ID: " + id);
						break;
					}
				}		
		        return id;
 	
	        }catch (Exception e){
       System.out.println("FAIL! "+e.getMessage());
       return null;
    
		}
	
	}
	
	public String searchWithId() {
		
        

		try {
		given()
	                .when()
	                .get(request1)
	                .then()
	                //.assertThat()
	                .body("title", not(emptyOrNullString()))
	                .body("year", not(emptyOrNullString()))
	                .log()
	                .all()
	                .contentType(ContentType.JSON)
	                .statusCode(200)
	                .and()
	                .extract()
		            .response();

		}catch (Exception e) {
			
		}
		return null;
	}
	
}
