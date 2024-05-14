package it.unife.ingsw202324.Chat.repositories;

import it.unife.ingsw202324.Chat.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;


// --- CLASSE CHE DEFINISCE IL REPOSITORY DI MESSAGE ---

public interface MessageRepository extends JpaRepository<Message, Long>{

}
