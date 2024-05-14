package it.unife.ingsw202324.Chat.repositories;

import it.unife.ingsw202324.Chat.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/* CLASSE CHE DEFINISCE IL REPOSITORY (TABELLA DEL DATABASE)  */
public interface UserRepository extends JpaRepository<User, Long> {

}
