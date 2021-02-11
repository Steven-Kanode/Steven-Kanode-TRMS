package kanode.steven.models;

public class TuitionBalance {
	
	private double amountLeft;
	private double amountPending;
	private double amountApproved;
	private int PK_TUITION_AMOUNTS_ID;
	private static String tableName = "TUITION_BALANCES";
	
	public TuitionBalance() {
		super();
	}

	public TuitionBalance(double amountLeft, double amountPending, double amountApproved, int pK_TUITION_AMOUNTS_ID) {
		super();
		this.amountLeft = amountLeft;
		this.amountPending = amountPending;
		this.amountApproved = amountApproved;
		PK_TUITION_AMOUNTS_ID = pK_TUITION_AMOUNTS_ID;
	}

	public TuitionBalance(double amountLeft, double amountPending, double amountApproved) {
		super();
		this.amountLeft = amountLeft;
		this.amountPending = amountPending;
		this.amountApproved = amountApproved;
	}

	public double getAmountLeft() {
		return amountLeft;
	}

	public void setAmountLeft(double amountLeft) {
		this.amountLeft = amountLeft;
	}

	public double getAmountPending() {
		return amountPending;
	}

	public void setAmountPending(double amountPending) {
		this.amountPending = amountPending;
	}

	public double getAmountApproved() {
		return amountApproved;
	}

	public void setAmountApproved(double amountApproved) {
		this.amountApproved = amountApproved;
	}

	public int getPK_TUITION_AMOUNTS_ID() {
		return PK_TUITION_AMOUNTS_ID;
	}

	public void setPK_TUITION_AMOUNTS_ID(int pK_TUITION_AMOUNTS_ID) {
		PK_TUITION_AMOUNTS_ID = pK_TUITION_AMOUNTS_ID;
	}

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		TuitionBalance.tableName = tableName;
	}

	@Override
	public String toString() {
		return "TuitionBalance [amountLeft=" + amountLeft + ", amountPending=" + amountPending + ", amountApproved="
				+ amountApproved + ", PK_TUITION_AMOUNTS_ID=" + PK_TUITION_AMOUNTS_ID + "]";
	}
	
	
}
