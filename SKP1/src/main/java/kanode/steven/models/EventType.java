package kanode.steven.models;

public class EventType {
	private int PK_EVENT_TYPES_ID;
	private String EVENT_TYPE;
	private static String tableName = "EVENT_TYPES";
	
	
	public EventType() {
		super();
		
	}

	public EventType(int pK_EVENT_TYPES_ID, String eVENT_TYPE) {
		super();
		PK_EVENT_TYPES_ID = pK_EVENT_TYPES_ID;
		EVENT_TYPE = eVENT_TYPE;
	}

	public EventType(String eVENT_TYPE) {
		super();
		EVENT_TYPE = eVENT_TYPE;
	}

	public int getPK_EVENT_TYPES_ID() {
		return PK_EVENT_TYPES_ID;
	}

	public void setPK_EVENT_TYPES_ID(int pK_EVENT_TYPES_ID) {
		PK_EVENT_TYPES_ID = pK_EVENT_TYPES_ID;
	}

	public String getEVENT_TYPE() {
		return EVENT_TYPE;
	}

	public void setEVENT_TYPE(String eVENT_TYPE) {
		EVENT_TYPE = eVENT_TYPE;
	}

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		EventType.tableName = tableName;
	}
	
	
	
	
}
