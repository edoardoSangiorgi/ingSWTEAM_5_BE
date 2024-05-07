package it.unife.ingsw202324.Chat.repositories;

import it.unife.ingsw202324.Chat.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

// --- CLASSE CHE DEFINISCE IL REPOSITORY DI CHAT
public interface ChatRepository extends JpaRepository<Chat, Long> {

}
