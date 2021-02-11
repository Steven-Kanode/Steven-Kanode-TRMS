package kanode.steven.models;

public class ReimbursementForm {
	
	private int PK_REIMBURSEMENT_FORM_ID;
	private int FK_EMPLOYEE_ID;
	private int FK_EVENT_ID;
	private int FK_TUITION_BALANCE; //same as empl id
	private int supervisorApproved;
	private int departmentheadApproved;
	private int bencoApproved;
	private static String tableName = "REIMBURSEMENT_FORMS";
	
	public ReimbursementForm() {
		super();
		this.supervisorApproved = 0;
		this.departmentheadApproved = 0;
		this.bencoApproved = 0;
	}
	
	public ReimbursementForm(int pK_REIMBURSEMENT_FORM_ID, int fK_EMPLOYEE_ID, int fK_EVENT_ID, int fK_TUITION_BALANCE,
			int supervisorApproved, int departmentheadApproved, int bencoApproved) {
		super();
		PK_REIMBURSEMENT_FORM_ID = pK_REIMBURSEMENT_FORM_ID;
		FK_EMPLOYEE_ID = fK_EMPLOYEE_ID;
		FK_EVENT_ID = fK_EVENT_ID;
		FK_TUITION_BALANCE = fK_TUITION_BALANCE;
		this.supervisorApproved = supervisorApproved;
		this.departmentheadApproved = departmentheadApproved;
		this.bencoApproved = bencoApproved;
	}
	
	
	public int getPK_REIMBURSEMENT_FORM_ID() {
		return PK_REIMBURSEMENT_FORM_ID;
	}

	public void setPK_REIMBURSEMENT_FORM_ID(int pK_REIMBURSEMENT_FORM_ID) {
		PK_REIMBURSEMENT_FORM_ID = pK_REIMBURSEMENT_FORM_ID;
	}

	public int getFK_EMPLOYEE_ID() {
		return FK_EMPLOYEE_ID;
	}

	public void setFK_EMPLOYEE_ID(int fK_EMPLOYEE_ID) {
		FK_EMPLOYEE_ID = fK_EMPLOYEE_ID;
	}

	public int getFK_EVENT_ID() {
		return FK_EVENT_ID;
	}

	public void setFK_EVENT_ID(int fK_EVENT_ID) {
		FK_EVENT_ID = fK_EVENT_ID;
	}

	public int getFK_TUITION_BALANCE() {
		return FK_TUITION_BALANCE;
	}

	public void setFK_TUITION_BALANCE(int fK_TUITION_BALANCE) {
		FK_TUITION_BALANCE = fK_TUITION_BALANCE;
	}

	public int getSupervisorApproved() {
		return supervisorApproved;
	}

	public void setSupervisorApproved(int supervisorApproved) {
		this.supervisorApproved = supervisorApproved;
	}

	public int getDepartmentheadApproved() {
		return departmentheadApproved;
	}

	public void setDepartmentheadApproved(int departmentheadApproved) {
		this.departmentheadApproved = departmentheadApproved;
	}

	public int getBencoApproved() {
		return bencoApproved;
	}

	public void setBencoApproved(int bencoApproved) {
		this.bencoApproved = bencoApproved;
	}

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		ReimbursementForm.tableName = tableName;
	}

	@Override
	public String toString() {
		return "ReimbursementForm [PK_REIMBURSEMENT_FORM_ID=" + PK_REIMBURSEMENT_FORM_ID + ", FK_EMPLOYEE_ID="
				+ FK_EMPLOYEE_ID + ", FK_EVENT_ID=" + FK_EVENT_ID + ", FK_TUITION_BALANCE=" + FK_TUITION_BALANCE
				+ ", supervisorApproved=" + supervisorApproved + ", departmentheadApproved=" + departmentheadApproved
				+ ", bencoApproved=" + bencoApproved + "]";
	}

	
	
}
