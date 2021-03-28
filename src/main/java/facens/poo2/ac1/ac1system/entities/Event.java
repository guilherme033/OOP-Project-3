package facens.poo2.ac1.ac1system.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import facens.poo2.ac1.ac1system.dto.EventInsertDTO;


@Entity
@Table(name = "TB_EVENT")
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id //Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    private String name;
    private String description;
    private String place;
    private LocalDate startdate;

    Event(){

    }
    
    public Event(EventInsertDTO dto) {
        
        this.name         = dto.getName();
        this.description  = dto.getDescription();
        this.place        = dto.getPlace();
        this.startdate    = dto.getStartdate();
       
	}
    

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public LocalDate getStartdate() {
        return startdate;
    }
    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
    
    @Override

    public int hashCode(){
        final int prime = 31;
        int       result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Event other = (Event) obj;

        if (id == null) {
            if (other.id != null)
                return false;
                    } else if (!id.equals(other.id))
                         return false;
                            return true;
    }
}