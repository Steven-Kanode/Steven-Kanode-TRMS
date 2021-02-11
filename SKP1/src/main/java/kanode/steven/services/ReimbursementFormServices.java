package kanode.steven.services;

import java.util.List;

import kanode.steven.models.EmployeeEventReview;
import kanode.steven.models.ReimbursementForm;
import kanode.steven.models.SupervisorEventReview;
import kanode.steven.models.UpdateMaker;
import kanode.steven.repositories.impl.ReimbursementFormRepoImpl;

public class ReimbursementFormServices {
	
	private ReimbursementFormRepoImpl rfr;

	public ReimbursementFormServices() {
		this.rfr = new ReimbursementFormRepoImpl();
	}
	
	public ReimbursementForm getReimbursementForm(int id) {
		return rfr.getReimbursementForm(id);
	}
	
	public List<ReimbursementForm> getReimbursementForms() {
		return rfr.getAllReimbursementForms();
	}
	
	public List<EmployeeEventReview> getReimbursementFormsByEmployee(int emplid){
		return rfr.getReimbursementFormsByEmployee(emplid);
	}
	
	public boolean deleteReimbursementForm(int id) {
		return rfr.deleteReimbursementForm(id);
	}

	public boolean addReimbursementForm(ReimbursementForm e) {
		return rfr.addReimbursementForm(e);
	}

	public boolean updateReimbursementForm(ReimbursementForm e) {
		return rfr.updateReimbursementForm(e);
	}
	
	public boolean updateReimbursementFormApproval(UpdateMaker um) {
		return rfr.updateReimbursementFormApproval(um);
	}

	public List<SupervisorEventReview> getReimbursementFormsBySupervisor(int emplid) {
		return rfr.getReimbursementFormsBySupervisor(emplid);
	}
	
}
