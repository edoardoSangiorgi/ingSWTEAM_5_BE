package it.unife.ingsw202324.Chat.repositories;

import it.unife.ingsw202324.Chat.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
