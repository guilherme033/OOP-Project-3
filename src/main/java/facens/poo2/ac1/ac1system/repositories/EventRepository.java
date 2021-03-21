package facens.poo2.ac1.ac1system.repositories;

import facens.poo2.ac1.ac1system.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {
    
}
