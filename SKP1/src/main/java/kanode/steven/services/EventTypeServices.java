package kanode.steven.services;

import java.util.List;

import kanode.steven.models.EventType;
import kanode.steven.repositories.impl.EventTypeRepoImpl;

public class EventTypeServices {
	private EventTypeRepoImpl etr;
	
	public EventTypeServices() {
		this.etr = new EventTypeRepoImpl();
	}
	
	public EventType getEventType(int id) {
		return etr.getEventType(id);
	}
	
	public List<EventType> getEventTypes(){
		return etr.getAllEventTypes();
	}
	
	public boolean deleteEventType(int id) {
		return etr.deleteEventType(id);
	}
	
	public boolean addEventType(EventType e) {
		return etr.addEventType(e);
	}
	
	public boolean updateEventType(EventType e) {
		return etr.updateEventType(e);
	}
}
