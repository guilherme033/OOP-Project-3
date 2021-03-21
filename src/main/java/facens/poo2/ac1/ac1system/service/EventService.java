package facens.poo2.ac1.ac1system.service;

import facens.poo2.ac1.ac1system.entities.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import facens.poo2.ac1.ac1system.dto.EventDTO;
import facens.poo2.ac1.ac1system.dto.EventInsertDTO;
import facens.poo2.ac1.ac1system.dto.EventUpdateDTO;
import facens.poo2.ac1.ac1system.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<EventDTO> getEvents() {
        List<Event> list = repository.findAll();
            return toDTOList(list);
    }

    public EventDTO geteventbyid(Long id) {
        Optional<Event> op = repository.findById(id);
            Event ev = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
                return new EventDTO(ev);
    }
    
    public EventDTO insert(EventInsertDTO dto){
        Event entity = new Event(dto);
            entity = repository.save(entity);
                return new EventDTO(entity);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    public EventDTO update(Long id, EventUpdateDTO dto){
      try{
        Event entity = repository.getOne(id);
            entity.setName(dto.getName());
                entity = repository.save(entity);
                     return new EventDTO(entity);
      }
      catch(EntityNotFoundException ex){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
      }
        
    }

    public List<EventDTO> toDTOList(List<Event> list) {

        List<EventDTO> listDTO = new ArrayList<>();

        for(Event e : list) {
            EventDTO dto = new EventDTO(e.getId(), e.getName());
                listDTO.add(dto);
        }

        return listDTO;
    }

}
