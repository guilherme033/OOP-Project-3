package facens.poo2.ac1.ac1system.controller;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import facens.poo2.ac1.ac1system.dto.EventDTO;
import facens.poo2.ac1.ac1system.dto.EventInsertDTO;
import facens.poo2.ac1.ac1system.service.EventService;

@RestController
@RequestMapping("/Events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public  ResponseEntity < List < EventDTO >> getEvents(){
            List < EventDTO > list = service.getEvents();
            return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public  ResponseEntity <EventDTO> getEventById(@PathVariable Long id){
            EventDTO dto = service.geteventbyid(id);
            return ResponseEntity.ok(dto);
    }

    @PostMapping 
    public  ResponseEntity <EventDTO> insert(@RequestBody EventInsertDTO insertDto){
            EventDTO dto = service.insert(insertDto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
    }
}
