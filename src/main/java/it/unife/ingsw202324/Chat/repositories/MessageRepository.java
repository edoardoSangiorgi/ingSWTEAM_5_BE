package it.unife.ingsw202324.Chat.repositories;

import it.unife.ingsw202324.Chat.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;


// --- CLASSE CHE DEFINISCE IL REPOSITORY DI MESSAGE ---

public interface MessageRepository extends JpaRepository<Message, Long>{

}
