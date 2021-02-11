package kanode.steven.models;

public class SupervisorEventReview {
	
	private String event_description;
	private String event_location;
	private int fk_event_type;
	private int fk_employee_id;
	private int cost;
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int supervisor_approved;
	private int department_head_approved;
	private int benco_approved;
	private int event_type;
	private String first_name;
	private String last_name;
	private String email;
	private int pk_event_id;
	
	public SupervisorEventReview() {
		super();
	}
	
	public SupervisorEventReview(String event_description, String event_location, int fk_event_type, int fk_employee_id,
			int cost, int day, int month, int year, int hour, int minute, int supervisor_approved,
			int department_head_approved, int benco_approved, int event_type, String first_name, String last_name,
			String email, int pk_event_id) {
		super();
		this.event_description = event_description;
		this.event_location = event_location;
		this.fk_event_type = fk_event_type;
		this.fk_employee_id = fk_employee_id;
		this.cost = cost;
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.supervisor_approved = supervisor_approved;
		this.department_head_approved = department_head_approved;
		this.benco_approved = benco_approved;
		this.event_type = event_type;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.setPk_event_id(pk_event_id);
	}





	public String getEvent_description() {
		return event_description;
	}
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	public String getEvent_location() {
		return event_location;
	}
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}
	public int getFk_event_type() {
		return fk_event_type;
	}
	public void setFk_event_type(int fk_event_type) {
		this.fk_event_type = fk_event_type;
	}
	public int getFk_employee_id() {
		return fk_employee_id;
	}
	public void setFk_employee_id(int fk_employee_id) {
		this.fk_employee_id = fk_employee_id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSupervisor_approved() {
		return supervisor_approved;
	}
	public void setSupervisor_approved(int supervisor_approved) {
		this.supervisor_approved = supervisor_approved;
	}
	public int getDepartment_head_approved() {
		return department_head_approved;
	}
	public void setDepartment_head_approved(int department_head_approved) {
		this.department_head_approved = department_head_approved;
	}
	public int getBenco_approved() {
		return benco_approved;
	}
	public void setBenco_approved(int benco_approved) {
		this.benco_approved = benco_approved;
	}


	public int getEvent_type() {
		return event_type;
	}


	public void setEvent_type(int i) {
		this.event_type = i;
	}





	public String getFirst_name() {
		return first_name;
	}





	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}





	public String getLast_name() {
		return last_name;
	}





	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public int getPk_event_id() {
		return pk_event_id;
	}





	public void setPk_event_id(int pk_event_id) {
		this.pk_event_id = pk_event_id;
	}
	
	

}
