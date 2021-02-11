package kanode.steven.models;

public class Gradebook {
	private int PK_GRADEBOOKS_ID;
	private int FK_EVENT_ID;
	private int gradingFormat;
	private int finalScore; // Do we do just pass/fail? 
	private static String tableName = "GRADEBOOKS";
	
	public Gradebook() {
		super();
	}


	public Gradebook(int pK_GRADEBOOKS_ID, int fK_EVENT_ID, int gradingFormat, int finalScore) {
		super();
		PK_GRADEBOOKS_ID = pK_GRADEBOOKS_ID;
		FK_EVENT_ID = fK_EVENT_ID;
		this.gradingFormat = gradingFormat;
		this.finalScore = finalScore;
	}


	public Gradebook(int gradingFormat, int finalScore) {
		super();
		this.gradingFormat = gradingFormat;
		this.finalScore = finalScore;
	}


	public int getPK_GRADEBOOKS_ID() {
		return PK_GRADEBOOKS_ID;
	}


	public void setPK_GRADEBOOKS_ID(int pK_GRADEBOOKS_ID) {
		PK_GRADEBOOKS_ID = pK_GRADEBOOKS_ID;
	}


	public int getFK_EVENT_ID() {
		return FK_EVENT_ID;
	}


	public void setFK_EVENT_ID(int fK_EVENT_ID) {
		FK_EVENT_ID = fK_EVENT_ID;
	}


	public int getGradingFormat() {
		return gradingFormat;
	}


	public void setGradingFormat(int gradingFormat) {
		this.gradingFormat = gradingFormat;
	}


	public int getFinalScore() {
		return finalScore;
	}


	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}


	public static String getTableName() {
		return tableName;
	}


	public static void setTableName(String tableName) {
		Gradebook.tableName = tableName;
	}
	
	
}
