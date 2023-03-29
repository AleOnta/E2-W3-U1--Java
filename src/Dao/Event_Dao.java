package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Event;
import utils.JpaUtil;

public class Event_Dao implements I_EventDao {

	@Override
	public void saveEvent(Event e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception er) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			System.out.println("Event added!");
		}
		
	}

	@Override
	public Event getEventById(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Event eventFound = null;
		try {
			em.getTransaction().begin();
			eventFound = em.find(Event.class, id);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return eventFound;
	}

	@Override
	public List<Event> findAllEvents() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query res = em.createNamedQuery("Events.findAll");
		return res.getResultList();
	}

	@Override
	public void deleteEvent(Event e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
		} catch (Exception er) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			System.out.println("Event deleted!");
		}
	}

	@Override
	public void updateEvent(Event e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
		} catch (Exception er) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			System.out.println("Event updated!");
		}
	}

}
