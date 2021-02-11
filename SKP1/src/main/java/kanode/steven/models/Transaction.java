package kanode.steven.models;

public class Transaction {
	private double transactionAmount;
	private int PK_TRANSACTION_ID;
	private int FK_TUITION_AMOUNTS_ID;
	private static String tableName = "TRANSACTIONS";
	
	public Transaction() {
		super();
	}
	
	public Transaction(double transactionAmount, int pK_TRANSACTION_ID, int fK_TUITION_AMOUNTS_ID) {
		super();
		this.transactionAmount = transactionAmount;
		PK_TRANSACTION_ID = pK_TRANSACTION_ID;
		FK_TUITION_AMOUNTS_ID = fK_TUITION_AMOUNTS_ID;
	}
	
	public Transaction(double transactionAmount) {
		super();
		this.transactionAmount = transactionAmount;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getPK_TRANSACTION_ID() {
		return PK_TRANSACTION_ID;
	}

	public void setPK_TRANSACTION_ID(int pK_TRANSACTION_ID) {
		PK_TRANSACTION_ID = pK_TRANSACTION_ID;
	}

	public int getFK_TUITION_AMOUNTS_ID() {
		return FK_TUITION_AMOUNTS_ID;
	}

	public void setFK_TUITION_AMOUNTS_ID(int fK_TUITION_AMOUNTS_ID) {
		FK_TUITION_AMOUNTS_ID = fK_TUITION_AMOUNTS_ID;
	}

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		Transaction.tableName = tableName;
	}
	
	
}
