package it.unife.ingsw202324.Chat.services;

import it.unife.ingsw202324.Chat.entities.User;
import it.unife.ingsw202324.Chat.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// SERVICE CLASS PER INTERROGARE IL DATABASE
// implementa ii metodi che comunicano con il Databse

@Service
public class UserService {

    private UserRepository userRepository;


    // --- LETTURA ---
    public List<User> getAll() {
        return userRepository.findAll();
    }


    // --- SCRITTURA ---
    public void addUsers(List<User> users) {
        userRepository.saveAll(users); // inserisci quell'oggetto nel DB
    }


    // --- ELIMINAZIONE ---
    public void deleteUsers(List<User> users){
        userRepository.deleteAll(users);
    }


    // --- AGGIORNAMENTO ---
    public void update(User user){
        userRepository.save(user);
    }


}
