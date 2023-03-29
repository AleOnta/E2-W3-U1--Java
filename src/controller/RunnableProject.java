package controller;

import java.time.LocalDate;
import java.util.List;

import Dao.Event_Dao;
import model.E_Type;
import model.Event;

public class RunnableProject {

	public static void main(String[] args) {
		
		Event e1 = new Event();
		e1.setTitle("Event1");
		e1.setDate(LocalDate.of(2023, 05, 18));
		e1.setDescription("Event in May");
        e1.setType(E_Type.PRIVATE);
        e1.setMaxParticipants(58);
        
        Event e2 = new Event();
		e2.setTitle("Event2");
		e2.setDate(LocalDate.of(2020, 01, 13));
		e2.setDescription("Event in Jan");
        e2.setType(E_Type.PUBLIC);
        e2.setMaxParticipants(115);
        
        Event e3 = new Event();
		e3.setTitle("Event3");
		e3.setDate(LocalDate.of(2022, 11, 30));
		e3.setDescription("Event in Nov");
        e3.setType(E_Type.PRIVATE);
        e3.setMaxParticipants(25);
        
        Event e4 = new Event();
		e4.setTitle("Event4");
		e4.setDate(LocalDate.of(2015, 06, 05));
		e4.setDescription("Event in June");
        e4.setType(E_Type.PUBLIC);
        e4.setMaxParticipants(250);
        
        Event e5 = new Event();
		e5.setTitle("Event5");
		e5.setDate(LocalDate.of(2012, 04, 21));
		e5.setDescription("Event in Apr");
        e5.setType(E_Type.PRIVATE);
        e5.setMaxParticipants(78);
		
        Event_Dao ed = new Event_Dao();
        
        // TASK 1 - Save a element into the DB
		ed.saveEvent(e1);
		ed.saveEvent(e2);
		ed.saveEvent(e3);
		ed.saveEvent(e4);
		ed.saveEvent(e5);
		
		// TASK 2 - Recover a element on the DB by ID
		System.out.println("\nEvent found searching for ID (2) --> " + ed.getEventById(2l)); 
		System.out.println("Event found searching for ID (3) --> " + ed.getEventById(3l));
		System.out.println("Event found searching for ID (4) --> " + ed.getEventById(4l) + "\n");
		
		// TASK 3 - Update event into DB
		System.out.println("Before update --> " + ed.getEventById(5l) + "\n");
		e5.setDescription("Description updated after element upload");
		ed.updateEvent(e5);
		System.out.println("After update --> " + ed.getEventById(5l) + "\n");
		
		// TASK 4 - Delete event from DB
		ed.deleteEvent(e5);
		
		// TASK 5 - Print all events in DB table
		List<Event> eventsList = ed.findAllEvents();
		System.out.println("\nHere's a list of all stored events:");
		for (Event e : eventsList) {
			System.out.println(e);
		}
	}

}
