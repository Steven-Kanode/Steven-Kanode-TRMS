package kanode.steven.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import kanode.steven.models.Employee;
import kanode.steven.services.EmployeeServices;

public class EmployeeController {
	
	/*
	 * Read any necessary information from the request
	 * Call the appropriate Service(s).
	 * Prepare our data to be added to the response
	 * Add said data into the Response Body.
	 * 
	 * Processing Requests and Generating Responses
	 */
	
	public static EmployeeServices es = new EmployeeServices();
	public static Gson gson = new Gson();
	
	public static void getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("id");
		String pass = request.getParameter("pass");
				
		Employee e = es.getEmployeeLogin(input, pass);
		
		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}
	
	public static void addEmployee(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		/*
		 * This time we are going to need to make a POST Request
		 * POST Requests are for creating (adding) data to your DB.
		 * 
		 * What's going to change is that you don't pass
		 * around data you plan to add via parameters.
		 * Instead, any non-GET Request has access to a
		 * Request Body.
		 */
		
		//GSON will convert a JSON passed into the Request Body
		//into an Object for your choosing.
		Employee a = gson.fromJson(request.getReader(), Employee.class);
		System.out.println(a.toString());
		//Call the appropriate Service for adding Actors
		boolean success = es.addEmployee(a);
		
		//Most common practice is to send back the added Object
		//Just in case the Client wants to use it again.
		response.getWriter().append((success) ? gson.toJson(a) : "{}");
		
		
	}

}
