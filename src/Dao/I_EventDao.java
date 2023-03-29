package Dao;

import java.util.List;
import model.Event;

public interface I_EventDao {
	
	public void saveEvent(Event e);
	public Event getEventById(long id);
	public List<Event> findAllEvents();
	public void deleteEvent(Event e);
	public void updateEvent(Event e);

}
