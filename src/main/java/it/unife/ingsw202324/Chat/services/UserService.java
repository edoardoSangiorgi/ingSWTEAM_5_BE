package it.unife.ingsw202324.Chat.services;

import it.unife.ingsw202324.Chat.entities.User;
import it.unife.ingsw202324.Chat.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// SERVICE CLASS PER INTERROGARE IL DATABASE
// implementa ii metodi che comunicano con il Database

@Service
public class UserService {

    private UserRepository userRepository;

    // --- CONVERSIONE DTO -----------------------
    public UserDTO convertToUserDTO(User user) { // from User to UserDTO
        UserDTO dto = new UserDTO();
        dto.setId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setTel(user.getTel());
        return dto;
    }


    // --- LETTURA MEMBRI DI UNA CHAT ---
    public List<User> getAll() {
        return userRepository.findAll();
    }


    // --- RICERCA DI UTENTI---
    public Optional<UserDTO> findUserByUsername(String username){
        /*
         * INPUT:
         *           username:   il nome con cui l'utente si è registrato
         *           String
         * OUTPUT:
         *           oggetto opzionale che contiente l'oggetto UserDTO che
         *           rappresenta l'utente cercato attraverso l'inserimento
         *           del nome utente.
         * */
        return userRepository.findByUsername(username).map(this::convertToUserDTO);
    }


    // --- SCRITTURA NUOVO UTENTE (Registrazione)---
    public UserDTO createUser(UserDTO userDTO) {

        /*
        * INPUT:
        *           userTDO:    l'oggetto user da salvare
        *           UserDTO
        *
        * OUTPUT:
        *           un oggetto UserDTO da restituire al client
        * */

        // -- creazione istanza e salvataggio attributi --
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setTel(userDTO.getTel());

        // -- scrittura su DB --
        User createdUser = userRepository.save(user);

        // -- conversione e ritorno --
        return convertToUserDTO(createdUser);
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
