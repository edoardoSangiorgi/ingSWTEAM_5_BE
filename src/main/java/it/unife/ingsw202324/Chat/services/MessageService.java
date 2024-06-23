package it.unife.ingsw202324.Chat.services;

import it.unife.ingsw202324.Chat.DTOs.MessageDTO;
import it.unife.ingsw202324.Chat.DTOs.UserDTO;
import it.unife.ingsw202324.Chat.entities.Chat;
import it.unife.ingsw202324.Chat.entities.Message;
import it.unife.ingsw202324.Chat.entities.User;
import it.unife.ingsw202324.Chat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatService chatService;
    @Autowired
    UserService userService;


    // -- C O N V E R T I T O R I --------------------------------------------------------------------------
    public Message convertFromDTO(MessageDTO request){
        /*
            INPUT:
                    request:    oggetto che contiene le informazioni del messaggio provenienti dal client
                    CreateRequestMessage

            OUTPUT:
                    message:    oggetto che contiene informazioni aggiuntive del messaggio
                    Message
         */

        Message message = new Message();
        User sender = userService.convertFromDTO(request.getSender());

        message.setContent(request.getContent());
        message.setSender(sender);
        message.setTimestamp(LocalDateTime.now());


        return message;
    }

    public MessageDTO convertToDTO(Message message){

        MessageDTO newDto = new MessageDTO();
        UserDTO senderDTO = userService.convertToDTO(message.getSender());

        newDto.setId(message.getId());
        newDto.setContent(message.getContent());
        newDto.setSender(senderDTO);
        newDto.setTimestamp(message.getTimestamp());

        return newDto;
    }



    // -- CREA UN NUOVO MESSAGGIO -------------------------------------------------------------------------
    public void createMessage(Message message, Long chatId){

        messageRepository.save(message);
    }


    // -- CERCA MESSAGGI DI UNA CHAT -----------------------------------------------------------------------
    public List<MessageDTO> getMessagesByChat(Chat chat){
        /*
            INPUT:
                    chatDTO:    oggetto DTO con le info sulla chat
                    ChatDTO

            COSA FA:
                    - trova i messaggi corrispondenti alla chat
                    - converte Message in MessageDTO

            OUTPUT:
                    dtoList:    lista di messaggi da ritornare al Client
                    List<MessageDTO>

         */
        List<Message> messageList = messageRepository.findByChat(chat);
        List<MessageDTO> dtoList = new ArrayList<>();
        for(Message message: messageList){
            dtoList.add(convertToDTO(message));
        }
        return dtoList;
    }


}
