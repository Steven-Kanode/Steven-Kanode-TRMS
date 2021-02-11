package kanode.steven.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kanode.steven.controllers.EmployeeController;
import kanode.steven.controllers.EventController;
import kanode.steven.controllers.ReimbursementFormController;
import kanode.steven.controllers.TuitionBalanceController;

public class RequestHelper {
	
	/**
	 * This method will delegate other methods on the controller
	 * layer of our application to process the request.
	 * @param request the HTTP Request
	 * @param response the HTTP Response
	 * @throws IOException 
	 */
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		switch (uri) {
		
		case "/SKP1/getEmployee.do": {
			System.out.println("getemployee");
			EmployeeController.getEmployee(request, response);
			break;
			
		}
		
		case "/SKP1/addEmployee.do": { 
			
			EmployeeController.addEmployee(request, response);
			break;
			
		}
		
		case "/SKP1/addEvent.do": { 
			
			EventController.addEvent(request, response);
			break;
			
		}
		
		case "/SKP1/getEvent.do":{
			EventController.getEvent(request, response);
			break;
		}
		
		case "/SKP1/updateReimbursementFormApprovals.do":{
			ReimbursementFormController.updateReimbursementFormApprovals(request, response);
			break;
		}
		
		case "/SKP1/employeePage.do":{
			//should only need the employee id to get all this information
			ReimbursementFormController.getAllReimbursementFormsByEmployee(request, response);
			break;
		}
		
		case "/SKP1/getBalances.do":{
			TuitionBalanceController.getTuitionBalance(request, response);
			break;
		}
		
		case "/SKP1/Supervisor-Page.do":{
			ReimbursementFormController.getAllReimbursementFormsBySupervisor(request, response);
			break;
		}
		
		default: {
			response.sendError(418, "Default case hit. Cannot brew coffee, is teapot.");
			break;
		}
		
		}
		
	}

}
