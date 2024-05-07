package it.unife.ingsw202324.Chat.services;


import it.unife.ingsw202324.Chat.models.Chat;
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
    public void addChats(List<Chat> chats){
        chatRepository.saveAll(chats);
    }


    // -- ELIMINAZIONE --
    public void deleteChats(List<Chat> chats){
        chatRepository.deleteAll(chats);
    }


    // -- AGGIORNAMENTO --
    public void update(Chat chat){
        chatRepository.save(chat);
    }

}
