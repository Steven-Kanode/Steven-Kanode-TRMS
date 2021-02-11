package kanode.steven.repositories.interfaces;

import java.util.List;

import kanode.steven.models.EventType;

public interface EventTypeRepoInt {
	public EventType getEventType(int id);
	public boolean addEventType(EventType e);
	public List<EventType> getAllEventTypes();
	public boolean updateEventType(EventType e);
	public boolean deleteEventType(int id);
}
