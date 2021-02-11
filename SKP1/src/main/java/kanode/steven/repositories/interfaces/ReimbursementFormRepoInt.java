package kanode.steven.repositories.interfaces;

import java.util.List;

import kanode.steven.models.ReimbursementForm;

public interface ReimbursementFormRepoInt {
	public ReimbursementForm getReimbursementForm(int id);
	public boolean addReimbursementForm(ReimbursementForm g);
	public List<ReimbursementForm> getAllReimbursementForms();
	public boolean updateReimbursementForm(ReimbursementForm g);
	public boolean deleteReimbursementForm(int id);
}
