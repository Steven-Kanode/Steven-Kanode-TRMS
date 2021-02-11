package kanode.steven.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import kanode.steven.models.Event;
import kanode.steven.services.EventServices;

public class EventController {
	
	public static EventServices es = new EventServices();
	
	public static Gson gson = new Gson();
	
	public static void getEvent(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		Event e = es.getEvent(id);
		System.out.println(e.toString());
		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}
	
	public static void addEvent(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		
		Event e = gson.fromJson(request.getReader(), Event.class);
		es.addEvent(e);
	}
	
	public static void updateEvent(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		/*
		 * This time we are going to need to make a POST Request POST Requests are for
		 * creating (adding) data to your DB.
		 * 
		 * What's going to change is that you don't pass around data you plan to add via
		 * parameters. Instead, any non-GET Request has access to a Request Body.
		 */

		// GSON will convert a JSON passed into the Request Body
		// into an Object for your choosing.
			
		
		Event e = gson.fromJson(request.getReader(), Event.class);
		es.updateEvent(e);
		
		
//		e.setFK_EMPLOYEE_ID(1);
//		System.out.println(e.toString());
		// Call the appropriate Service for adding Actors
		//boolean success = es.addEvent(e);
		
		// Most common practice is to send back the added Object
		// Just in case the Client wants to use it again.
		//response.getWriter().append((success) ? gson.toJson(e) : "{}");
		
	}
}
