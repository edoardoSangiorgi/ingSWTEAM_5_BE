package it.unife.ingsw202324.Chat.repositories;

import it.unife.ingsw202324.Chat.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/* CLASSE CHE DEFINISCE IL REPOSITORY (TABELLA DEL DATABASE)  */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
