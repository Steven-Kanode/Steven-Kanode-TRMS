package kanode.steven.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import kanode.steven.models.EmployeeEventReview;
import kanode.steven.models.ReimbursementForm;
import kanode.steven.models.SupervisorEventReview;
import kanode.steven.models.UpdateMaker;
import kanode.steven.services.ReimbursementFormServices;

public class ReimbursementFormController {

	public static ReimbursementFormServices rfs = new ReimbursementFormServices();

	public static Gson gson = new Gson();

	public static void getReimbursementForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		ReimbursementForm rf = rfs.getReimbursementForm(id);
		System.out.println(rf.toString());
		response.getWriter().append((rf != null) ? gson.toJson(rf) : "{}");
	}
	
	public static void getAllReimbursementFormsByEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String input = request.getParameter("id");
		int emplid;
		
		try {
			emplid = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		List<EmployeeEventReview> rf = rfs.getReimbursementFormsByEmployee(emplid);
		
		response.getWriter().append((rf != null) ? gson.toJson(rf) : "{}");
		
	}
	
	public static void getAllReimbursementFormsBySupervisor(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String input = request.getParameter("id");
		int emplid;
		
		try {
			emplid = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		List<SupervisorEventReview> rf = rfs.getReimbursementFormsBySupervisor(emplid);
		System.out.println(rf.size());
		response.getWriter().append((rf != null) ? gson.toJson(rf) : "{}");
		
	}
	
	public static void updateReimbursementFormApprovals(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		
		UpdateMaker um = gson.fromJson(request.getReader(), UpdateMaker.class);
		rfs.updateReimbursementFormApproval(um);

	}
	
}