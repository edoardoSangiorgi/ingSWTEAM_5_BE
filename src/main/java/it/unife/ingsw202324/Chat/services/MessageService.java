package it.unife.ingsw202324.Chat.services;

import it.unife.ingsw202324.Chat.DTOs.ChatDTO;
import it.unife.ingsw202324.Chat.DTOs.MessageRequest;
import it.unife.ingsw202324.Chat.DTOs.MessageDTO;
import it.unife.ingsw202324.Chat.entities.Chat;
import it.unife.ingsw202324.Chat.entities.Message;
import it.unife.ingsw202324.Chat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    // --- A T T R I B U T I  D E L  S E R V I Z I O ---
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatService chatService;


    // -- CONVERTITORE: CreateMessageRequest -> Message
    private Message convertFromMessageRequest(MessageRequest request){
        /*
            INPUT:
                    request:    oggetto che contiene le informazioni del messaggio provenienti dal client
                    CreateRequestMessage

            OUTPUT:
                    message:    oggetto che contiene informazioni aggiuntive del messaggio
                    Message
         */
        ChatDTO chat = chatService.getChat(request.getChatId());

        Message message = new Message();
        message.setContent(request.getContent());
        message.setSenderId(request.getSenderId());
        message.setTimestamp(LocalDateTime.now());

        return message;
    }


    // CONVERTITORE: Message -> MessageDTO
    private MessageDTO convertToMessageDTO(Message message){
        MessageDTO newDto = new MessageDTO();

        newDto.setId(message.getMessageId());
        newDto.setChat(message.getChat());
        newDto.setContent(message.getContent());
        newDto.setSenderId(message.getSenderId());
        newDto.setTimestamp(message.getTimestamp());

        return newDto;
    }


    // -- CREA UN NUOVO MESSAGGIO --
    public MessageDTO createMessage(MessageRequest request){

        Message message = convertFromMessageRequest(request);
        messageRepository.save(message);
        return convertToMessageDTO(message);
    }


    // -- CERCA MESSAGGI DI UNA CHAT --
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
            dtoList.add(convertToMessageDTO(message));
        }
        return dtoList;
    }




}
