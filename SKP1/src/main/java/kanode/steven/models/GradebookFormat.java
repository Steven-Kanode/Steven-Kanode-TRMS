package kanode.steven.models;

public class GradebookFormat {
	private int PK_GRADEBOOK_FORMAT;
	private String gradingType;
	private static String tableName = "GRADEBOOK_FORMATS";
	
	
	public GradebookFormat() {
		super();
	}

	public GradebookFormat(int pK_GRADEBOOK_FORMAT, String gradingType) {
		super();
		PK_GRADEBOOK_FORMAT = pK_GRADEBOOK_FORMAT;
		this.gradingType = gradingType;
	}

	public int getPK_GRADEBOOK_FORMAT() {
		return PK_GRADEBOOK_FORMAT;
	}

	public void setPK_GRADEBOOK_FORMAT(int pK_GRADEBOOK_FORMAT) {
		PK_GRADEBOOK_FORMAT = pK_GRADEBOOK_FORMAT;
	}

	public String getGradingType() {
		return gradingType;
	}

	public void setGradingType(String gradingType) {
		this.gradingType = gradingType;
	}

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		GradebookFormat.tableName = tableName;
	}
	
	
}
