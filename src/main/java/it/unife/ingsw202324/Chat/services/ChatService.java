package it.unife.ingsw202324.Chat.services;


import it.unife.ingsw202324.Chat.DTOs.ChatDTO;
import it.unife.ingsw202324.Chat.DTOs.ChatRequest;
import it.unife.ingsw202324.Chat.DTOs.MessageDTO;
import it.unife.ingsw202324.Chat.entities.Chat;
import it.unife.ingsw202324.Chat.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {


    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageService messageService;



    // -- CONVERTITORE CreateChatReqeust -> Chat
    private Chat createChatRequestToChat(ChatRequest request){
        /*
            INPUT:
                    request:    l'orggetto che contiene tutte le informazioni riguardo la chat passato dal client
                    CreateChatRequest

            OUTPUT:
                    chat:       l'oggetto da salvare sul DB
                    Chat
         */
        Chat chat = new Chat();

        long id = 0; // TODO: algoritmo per assegnamento id
        chat.setChatId(id);
        chat.setChatName(request.getChatName());
        chat.setState("active");
        if(request.getMemberIds().size() == 1){
            chat.setType("single");
        } else {
            chat.setType("group");
        }
        chat.setMemberIds(request.getMemberIds());

        return chat;
    }


    // -- CONVERTITORE Chat -> ChatDTO
    private ChatDTO convertToChatDTO(Chat chat){
        /*
            INPUT:
                    chat:   oggetto che mappa la chat sul DB
                    Chat

            OUTPUT:
                    dto:    oggetto che mappa la chat ad alto livello
                    ChatDTO
         */
        ChatDTO newDto = new ChatDTO();

        newDto.setChatId(chat.getChatId());
        newDto.setChatName(chat.getChatName());
        newDto.setType(chat.getType());
        newDto.setState(chat.getState());
        newDto.setMemberIds(chat.getMemberIds());

        return newDto;
    }


    // --- LETTURA DI UNA SINGOLA CHAT --
    public ChatDTO getChat(Long chatId){
        /*
            INPUT:
                    chatId:     l'id della chat specifica da cercare
                    Long

            OUTPUT:
                    ChatDTO:    L'oggetto chatDTO da restituire al client
         */
        // -- cerca la chat dal DB
        Optional<Chat> requestedChat = chatRepository.findById(chatId);

        // -- se la chat è stata trovata l'oggetto chat viene convertito in oggetto DTO
        if(requestedChat.isPresent()){
            Chat foundChat = requestedChat.get();

            // -- trova i messaggi collegati alla chat
            List<MessageDTO> messageDTOList = messageService.getMessagesByChat(foundChat);

            // -- inserisco i messaggi nel DTO
            ChatDTO outChatDTO = convertToChatDTO(foundChat);
            outChatDTO.setMessages(messageDTOList);

            return outChatDTO;


        } else {
            // -- altrimenti viene restituito null
            // TODO: sfrutta questo valore per messaggi di errore lato client
            return null;
        }


    }


    // -- LETTURA DI TUTTE LE CHAT --
    public List<ChatDTO> getAll(){
        List<Chat> chatList = chatRepository.findAll();
        List<ChatDTO> dtoList = new ArrayList<>();
        for(Chat chat: chatList){
            dtoList.add(convertToChatDTO(chat));
        }
        return dtoList;
    }


    // -- CREAZIONE NUOVA CHAT --
    public void createChat(ChatRequest request){
        /*
            INPUT:
                    request:    l'oggetto che coniene le info della chat dal client
                    CreateRequestChat

            COSA FA:
                    - converte request in un'oggetto chat
                    - salva l'oggetto chat sul DB
         */
        Chat newChat = createChatRequestToChat(request);
        chatRepository.save(newChat);
    }


    // -- ELIMINAZIONE --
    public void deleteChat(Long chatId){
        chatRepository.deleteById(chatId);
    }



}
