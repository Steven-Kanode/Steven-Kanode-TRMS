package kanode.steven.models;

public class Department {
	private int PK_DEPARTMENT_ID;
	private int FK_DEPARTMENT_HEAD_EMPLOYEE_ID;
	private String name;
//	private static String tableName = "DEPARTMENTS";
//	private static String[] tableAttributes = {"AMOUNT_LEFT", "AMOUNT_PENDING", "AMOUNT APPROVED", "PK_TUITION_AMOUNTS_ID"};
	
	public Department() {
		super();
	}


	public Department(int dEPARTMENT_ID, int fK_DEPARTMENT_HEAD_EMPLOYEE_ID, String name) {
		super();
		this.PK_DEPARTMENT_ID = dEPARTMENT_ID;
		this.FK_DEPARTMENT_HEAD_EMPLOYEE_ID = fK_DEPARTMENT_HEAD_EMPLOYEE_ID;
		this.name = name;
	}

	
	public Department(int fK_DEPARTMENT_HEAD_EMPLOYEE_ID, String name) {
		super();
		this.FK_DEPARTMENT_HEAD_EMPLOYEE_ID = fK_DEPARTMENT_HEAD_EMPLOYEE_ID;
		this.name = name;
	}


	public Department(String name) {
		super();
		this.name = name;
	}
	

	public int getPK_DEPARTMENT_ID() {
		return PK_DEPARTMENT_ID;
	}


	public void setPK_DEPARTMENT_ID(int pK_DEPARTMENT_ID) {
		this.PK_DEPARTMENT_ID = pK_DEPARTMENT_ID;
	}


	public int getFK_DEPARTMENT_HEAD_EMPLOYEE_ID() {
		return FK_DEPARTMENT_HEAD_EMPLOYEE_ID;
	}


	public void setFK_DEPARTMENT_HEAD_EMPLOYEE_ID(int fK_DEPARTMENT_HEAD_EMPLOYEE_ID) {
		this.FK_DEPARTMENT_HEAD_EMPLOYEE_ID = fK_DEPARTMENT_HEAD_EMPLOYEE_ID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


//	public static String getTableName() {
//		return tableName;
//	}
//
//
//	public static void setTableName(String tableName) {
//		Department.tableName = tableName;
//	}

//
//	public static String[] getTableAttributes() {
//		return tableAttributes;
//	}
//
//
//	public static void setTableAttributes(String[] tableAttributes) {
//		Department.tableAttributes = tableAttributes;
//	}


	@Override
	public String toString() {
		return "Department [PK_DEPARTMENT_ID=" + PK_DEPARTMENT_ID + ", FK_DEPARTMENT_HEAD_EMPLOYEE_ID="
				+ FK_DEPARTMENT_HEAD_EMPLOYEE_ID + ", name=" + name + "]";
	}
	
	
}
