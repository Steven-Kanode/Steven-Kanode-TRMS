package kanode.steven.repositories.interfaces;

import java.util.List;

import kanode.steven.models.Event;

public interface EventRepoInt {
	public Event getEvent(int id);
	public boolean addEvent(Event e);
	public List<Event> getAllEvents();
	public boolean updateEvent(Event e);
	public boolean deleteEvent(int id);
}

