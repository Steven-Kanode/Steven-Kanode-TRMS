package kanode.steven.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kanode.steven.models.Employee;
import kanode.steven.services.EmployeeServices;

public class EmployeePageController {
	
	public static EmployeeServices es = new EmployeeServices();
	public static Gson gson = new Gson();
	
public static void getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		Employee e = es.getEmployee(id);
		
		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");
	}

}

