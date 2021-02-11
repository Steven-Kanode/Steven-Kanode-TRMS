package kanode.steven.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kanode.steven.models.TuitionBalance;
import kanode.steven.services.TuitionBalanceServices;

public class TuitionBalanceController {
	
	public static TuitionBalanceServices tbs = new TuitionBalanceServices();
	public static Gson gson = new Gson();
	
	public static void getTuitionBalance(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		TuitionBalance tb = tbs.getTuitionBalance(id);

		response.getWriter().append((tb != null) ? gson.toJson(tb) : "{}");
	}
}
