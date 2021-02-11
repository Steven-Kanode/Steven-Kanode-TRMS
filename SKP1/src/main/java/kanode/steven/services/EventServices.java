package kanode.steven.services;

import java.util.List;

import kanode.steven.models.Event;
import kanode.steven.repositories.impl.EventRepoImpl;

public class EventServices {
	
	private EventRepoImpl es;
	
	public EventServices() {
		this.es = new EventRepoImpl();
	}
	
	public Event getEvent(int id) {
		return es.getEvent(id);
	}
	
	public List<Event> getEvents(){
		return es.getAllEvents();
	}
	
	public boolean deleteEvent(int id) {
		return es.deleteEvent(id);
	}
	
	public boolean addEvent(Event e) {
		return es.addEvent(e);
	}
	
	public boolean updateEvent(Event e) {
		return es.updateEvent(e);
	}
}
