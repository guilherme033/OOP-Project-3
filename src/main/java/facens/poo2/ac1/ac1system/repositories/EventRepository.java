package facens.poo2.ac1.ac1system.repositories;
import facens.poo2.ac1.ac1system.entities.Event;
import java.time.LocalDate;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {

     @Query("SELECT e FROM Event e "    + "WHERE"                                   + 
     "( LOWER(e.name) LIKE   LOWER(CONCAT('%', :name,    '%')))  AND"               +
     "( LOWER(e.description)   LIKE   LOWER(CONCAT('%', :description, '%'))) AND"   +
     "( LOWER(e.place)   LIKE   LOWER(CONCAT('%', :place, '%'))) AND"               +
     "( LOWER(e.startdate)   LIKE   LOWER(CONCAT('%', :startdate, '%')))"       
     
)

public Page <Event> find(Pageable pageRequest, String name, String description, String place, LocalDate startedate);

}
 