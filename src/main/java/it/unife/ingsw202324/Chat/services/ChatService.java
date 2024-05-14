package it.unife.ingsw202324.Chat.services;


import it.unife.ingsw202324.Chat.entities.Chat;
import it.unife.ingsw202324.Chat.repositories.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private ChatRepository chatRepository;

    // -- LETTURA --
    public List<Chat> getAll(){
        return chatRepository.findAll();
    }


    // -- SCRITTURA --
    public void addChat(Chat chat){
        chatRepository.save(chat);
    }


    // -- ELIMINAZIONE --
    public void deleteChat(Chat chat){
        chatRepository.delete(chat);
    }


    // -- AGGIORNAMENTO --
    public void update(Chat chat){
        chatRepository.save(chat);
    }

}
