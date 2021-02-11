package kanode.steven.models;

import java.sql.Date;
import java.sql.Time;

public class Event {
	
	private String eventDescription;
	private String eventLocation;
	private int type;
	private int FK_EMPLOYEE_ID;
	private int PK_EVENT_ID;
	private int FK_EVENT_TYPE_ID;
	private int hour;
	private int minute;
	private int second;
	private int day;
	private int month;
	private int year;
	
	private double cost;
	
	public Event() {
		super();
	}
	
	public Event(String eventDescription, String eventLocation, Date eventDate, Time eventTime, int type,
			int fK_EMPLOYEE_ID, int pK_EVENT_ID, int fK_EVENT_TYPE_ID, int hour, int minute, int second, int day,
			int month, int year, double cost) {
		super();
		this.eventDescription = eventDescription;
		this.eventLocation = eventLocation;
		this.type = type;
		this.FK_EMPLOYEE_ID = fK_EMPLOYEE_ID;
		this.PK_EVENT_ID = pK_EVENT_ID;
		this.FK_EVENT_TYPE_ID = fK_EVENT_TYPE_ID;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.day = day;
		this.month = month;
		this.year = year;
		this.cost = cost;
	}

	public Event(String eventDescription, String eventLocation, Date eventDate, Time eventTime, int type, double cost) {
		this.eventDescription = eventDescription;
		this.eventLocation = eventLocation;
		this.type = type;
		this.cost = cost;
	}
	
	public Event(String eventDescription, String eventLocation, Date eventDate, Time eventTime) {
		super();
		this.eventDescription = eventDescription;
		this.eventLocation = eventLocation;
	}

	
	public Event(String eventDescription, String eventLocation, Date eventDate, Time eventTime, int type,
			int fK_EMPLOYEE_ID, int pK_EVENT_ID, double cost) {
		super();
		this.eventDescription = eventDescription;
		this.eventLocation = eventLocation;
		this.type = type;
		FK_EMPLOYEE_ID = fK_EMPLOYEE_ID;
		PK_EVENT_ID = pK_EVENT_ID;
		this.cost = cost;
	}

	
	public Event(String eventDescription, String eventLocation, Date eventDate, Time eventTime, int type,
			int fK_EMPLOYEE_ID, double cost) {
		super();
		this.eventDescription = eventDescription;
		this.eventLocation = eventLocation;
		this.type = type;
		FK_EMPLOYEE_ID = fK_EMPLOYEE_ID;
		this.cost = cost;
	}


	public Event(String eventDescription, String eventLocation, Date eventDate, Time eventTime, int type,
			int fK_EMPLOYEE_ID) {
		super();
		this.eventDescription = eventDescription;
		this.eventLocation = eventLocation;
		this.type = type;
		FK_EMPLOYEE_ID = fK_EMPLOYEE_ID;
	}

	
	public Event(String eventDescription, String eventLocation, Date eventDate, Time eventTime,
			int type, int fK_EMPLOYEE_ID, int pK_EVENT_ID) {
		super();
		this.eventDescription = eventDescription;
		this.eventLocation = eventLocation;
		this.type = type;
		FK_EMPLOYEE_ID = fK_EMPLOYEE_ID;
		PK_EVENT_ID = pK_EVENT_ID;
	}

	
	public Event(int pK_EVENT_ID) {
		super();
		PK_EVENT_ID = pK_EVENT_ID;
	}

	
	public String getEventDescription() {
		return eventDescription;
	}


	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}


	public String getEventLocation() {
		return eventLocation;
	}

	
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}


	public int gettype() {
		return type;
	}


	public void settype(int type) {
		this.type = type;
	}


	public int getFK_EMPLOYEE_ID() {
		return FK_EMPLOYEE_ID;
	}


	public void setFK_EMPLOYEE_ID(int fK_EMPLOYEE_ID) {
		FK_EMPLOYEE_ID = fK_EMPLOYEE_ID;
	}


	public int getPK_EVENT_ID() {
		return PK_EVENT_ID;
	}


	public void setPK_EVENT_ID(int pK_EVENT_ID) {
		PK_EVENT_ID = pK_EVENT_ID;
	}



	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
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

	public int getFK_EVENT_TYPE_ID() {
		return FK_EVENT_TYPE_ID;
	}

	public void setFK_EVENT_TYPE_ID(int fK_EVENT_TYPE_ID) {
		FK_EVENT_TYPE_ID = fK_EVENT_TYPE_ID;
	}

	@Override
	public String toString() {
		return "Event [eventDescription=" + eventDescription + ", eventLocation=" + eventLocation + " type=" + type + ", FK_EMPLOYEE_ID=" + FK_EMPLOYEE_ID
				+ ", PK_EVENT_ID=" + PK_EVENT_ID + ", FK_EVENT_TYPE_ID=" + FK_EVENT_TYPE_ID + ", hour=" + hour
				+ ", minute=" + minute + ", second=" + second + ", day=" + day + ", month=" + month + ", year=" + year
				+ ", cost=" + cost + "]";
	}
	
	
	
	
}
