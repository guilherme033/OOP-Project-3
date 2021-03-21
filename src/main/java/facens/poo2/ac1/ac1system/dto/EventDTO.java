package facens.poo2.ac1.ac1system.dto;

import facens.poo2.ac1.ac1system.entities.Event;

public class EventDTO {

    private Long id;
    private String name;
    
    
    public EventDTO() {
	}

    public EventDTO(Long id, String name) {
        this.id = id;
        this.name = name;
	}

	public EventDTO(Event ev) {
        this.id = ev.getId();
        this.name = ev.getName();
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
