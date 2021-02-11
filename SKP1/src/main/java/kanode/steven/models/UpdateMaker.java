package kanode.steven.models;

public class UpdateMaker {
	private int approverType;
	private int approveDeny;
	private int rfid; //request form id
	
	public UpdateMaker (int at, int ad, int rfid) {
		this.approverType = at;
		this.approveDeny = ad;
		this.rfid = rfid;
	}

	public int getApproverType() {
		return approverType;
	}

	public void setApproverType(int approverType) {
		this.approverType = approverType;
	}

	public int getApproveDeny() {
		return approveDeny;
	}

	public void setApproveDeny(int approveDeny) {
		this.approveDeny = approveDeny;
	}

	public int getRfid() {
		return rfid;
	}

	public void setRfid(int rfid) {
		this.rfid = rfid;
	}
	
}
