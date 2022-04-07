package automacaoDBC.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

	
	public class TesteAPI 
{
	@Test
	public void cadastrarUsuario() 
	{
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("name", "jeferson");
		json.put("job", "qa");
		
		request.body(json.toJSONString());
		Response response = request.post("https://reqres.in/api/users");
		assertEquals(201, response.getStatusCode());
		
		System.out.println(response.asPrettyString());
		System.out.println("\nStatus Code "  + response.getStatusCode());
		
	}
	
	@Test
	public void consultarSingleUser() 
	{
		
		Response response = RestAssured.get("https://reqres.in/api/users/3");
		assertEquals(200, response.getStatusCode());
		
		System.out.println(response.asPrettyString());
		System.out.println("\nStatus Code "  + response.getStatusCode());
		
	}
	@Test
	public void consultarListaUsuarios() 
	{
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=1");
		
		System.out.println(response.asPrettyString());
		System.out.println("\nStatus Code "  + response.getStatusCode());
						
	}
	
	@Test
	public void atualizarUsuario() 
	{
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("name", "teste dbc");
		json.put("job", "analista de teste qa");
		
		request.body(json.toJSONString());
		Response response = request.patch("https://reqres.in/api/users/982");
		assertEquals(200, response.getStatusCode());
		String bodyResponse = response.asPrettyString();
		String retornoName = "teste dbc";
		String retornoJob = "analista de teste qa";
		
		System.out.println(response.asPrettyString());
		System.out.println("\nStatus Code "  + response.getStatusCode());
		System.out.println(bodyResponse.contains(retornoName));
		System.out.println(bodyResponse.contains(retornoJob));
		
	}
}
