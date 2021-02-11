package kanode.steven.models;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String email;
	private int PK_EMPLOYEE_ID;
	private int FK_SUPERVISOR_ID;
	private static String tableName = "EMPLOYEES";
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String email, int FK_EMPLOYEE_ID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.FK_SUPERVISOR_ID = FK_EMPLOYEE_ID;
	}
	

	public Employee(String firstName, String lastName, String email, int pK_EMPLOYEE_ID, int fK_SUPERVISOR_ID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		PK_EMPLOYEE_ID = pK_EMPLOYEE_ID;
		FK_SUPERVISOR_ID = fK_SUPERVISOR_ID;
	}

	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPK_EMPLOYEE_ID() {
		return PK_EMPLOYEE_ID;
	}

	public void setId(int PK_EMPLOYEE_ID) {
		this.PK_EMPLOYEE_ID = PK_EMPLOYEE_ID;
	}

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		Employee.tableName = tableName;
	}

	public int getFK_SUPERVISOR_ID() {
		return FK_SUPERVISOR_ID;
	}

	public void setFK_SUPERVISOR_ID(int fK_SUPERVISOR_ID) {
		FK_SUPERVISOR_ID = fK_SUPERVISOR_ID;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", PK_EMPLOYEE_ID="
				+ PK_EMPLOYEE_ID + ", FK_SUPERVISOR_ID=" + FK_SUPERVISOR_ID + "]";
	}
	
	
	
}
