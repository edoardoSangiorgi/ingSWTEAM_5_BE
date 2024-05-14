package it.unife.ingsw202324.Chat.services;

import it.unife.ingsw202324.Chat.entities.Message;
import it.unife.ingsw202324.Chat.repositories.MessageRepository;

import java.util.List;

public class MessageService {

    private MessageRepository messageRepository;

    // --- LETTURA ---
    public List<Message> getAll(){
        return messageRepository.findAll();
    }


    // --- SCRITTURA ---
    public void addMessages(Message message){
        messageRepository.save(message);
    }


    // --- ELIMINAZIONE ---
    public void deleteMessages(List<Message> messages){
        messageRepository.deleteAll(messages);
    }

    // --- AGGIORNAMENTO ---
    public void update(Message message){
        messageRepository.save(message);
    }

}
