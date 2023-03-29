package model;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "events")
@NamedQuery(name = "Events.findAll", query = "SELECT e FROM Event e")
@Getter
@Setter
@ToString
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private long id;
	@Column(nullable = false)
	private String title;
	@Column(name = "event_date", nullable = false)
	private LocalDate date;
	@Column(nullable = false)
	private String description;
	@Column(name = "event_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private E_Type type;
	@Column(name = "max_participants", nullable = false)
	private int maxParticipants;
	
	public Event() {
		
	}
	
	public Event(String title, LocalDate date, String description, E_Type type, int maxParticipants) {
		super();
		this.title = title;
		this.date = date;
		this.description = description;
		this.type = type;
		this.maxParticipants = maxParticipants;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", date=" + date + ", description=" + description + ", type="
				+ type + ", maxParticipants=" + maxParticipants + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public E_Type getType() {
		return type;
	}

	public void setType(E_Type type) {
		this.type = type;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public long getId() {
		return id;
	}
	
	
	/*public Event(long id, String title, String date, String description, E_Type type, int maxParticipants) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.description = description;
		this.type = type;
		this.maxParticipants = maxParticipants;
	}*/
	
	
}
