package it.unife.ingsw202324.Chat.services;


import it.unife.ingsw202324.Chat.DTOs.ChatDTO;
import it.unife.ingsw202324.Chat.DTOs.MessageDTO;
import it.unife.ingsw202324.Chat.DTOs.UserDTO;
import it.unife.ingsw202324.Chat.entities.Chat;
import it.unife.ingsw202324.Chat.entities.Message;
import it.unife.ingsw202324.Chat.entities.User;
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
    @Autowired
    private UserService userService;



    // -- C O N V E R T I T O R I --------------------------------------------------------------------------
    public Chat convertFromDTO(ChatDTO request){
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
        chat.setId(id);
        chat.setName(request.getChatName());
        chat.setState("active");
        if(request.getMembers().size() == 1) chat.setType("single");
        else chat.setType("group");

        List<UserDTO> membersList = request.getMembers();
        List<User> convertedMembersList = new ArrayList<>();
        for(UserDTO member: membersList){
            convertedMembersList.add(userService.convertFromDTO(member));
        }
        chat.setMembers(convertedMembersList);


        return chat;
    }

    public ChatDTO convertToDTO(Chat chat){
        /*
            INPUT:
                    chat:   oggetto che mappa la chat sul DB
                    Chat

            OUTPUT:
                    dto:    oggetto che mappa la chat ad alto livello
                    ChatDTO
         */
        ChatDTO newDto = new ChatDTO();

        newDto.setId(chat.getId());
        newDto.setChatName(chat.getName());
        newDto.setType(chat.getType());
        newDto.setState(chat.getState());

        /* Conversione della lista User a lista UserDTO*/
        List<User> membersList = chat.getMembers();
        List<UserDTO> convertedMembersList = new ArrayList<>();
        for(User member: membersList){
            convertedMembersList.add(userService.convertToDTO(member));
        }
        newDto.setMembers(convertedMembersList);

        /* Conversione della lista Message a lista MessageDTO*/
        List<Message> messageList = chat.getMessages();
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for(Message message: messageList){
            messageDTOList.add(messageService.convertToDTO(message));
        }
        newDto.setMessages(messageDTOList);

        return newDto;
    }



    // --- LETTURA SINGOLA CHAT -----------------------------------------------------------------------------
    public ChatDTO getChat(ChatDTO chat){
        /*
            INPUT:
                    chatId:     l'id della chat specifica da cercare
                    Long

            OUTPUT:
                    ChatDTO:    L'oggetto chatDTO da restituire al client
                                che contiene anche tutti i messaggi da stampare
         */

        // -- cerca la chat dal DB

        Optional<Chat> requestedChat = chatRepository.findById(chat.getId());

        // -- se la chat è stata trovata l'oggetto chat viene convertito in oggetto DTO
        if(requestedChat.isPresent()){
            Chat foundChat = requestedChat.get();
            return convertToDTO(foundChat);


        } else {
            // -- altrimenti viene restituito null
            // TODO: sfrutta questo valore per messaggi di errore lato client
            return null;
        }


    }


    // -- LETTURA LISTA CHAT --------------------------------------------------------------------------------
    public List<ChatDTO> getAll(){
        List<Chat> chatList = chatRepository.findAll();
        List<ChatDTO> dtoList = new ArrayList<>();
        for(Chat chat: chatList){
            dtoList.add(convertToDTO(chat));
        }
        return dtoList;
    }


    // -- CREAZIONE NUOVA CHAT ------------------------------------------------------------------------------
    public void createChat(ChatDTO request){
        /*
            INPUT:
                    request:    l'oggetto che coniene le info della chat dal client
                    CreateRequestChat

            COSA FA:
                    - converte request in un'oggetto chat
                    - salva l'oggetto chat sul DB
         */
        Chat newChat = convertFromDTO(request);
        // TODO: salva utenti sul DB
        chatRepository.save(newChat);
    }


    // -- UPDATE CHAT ---------------------------------------------------------------------------------------
    public ChatDTO updateChat(Chat chatToUpdate){
        /*
            CASI D'USO:
                - inserimento nuovi utenti
                - modifica attributi chat
         */
        chatRepository.save(chatToUpdate);
        return this.convertToDTO(chatToUpdate);

    }


    // -- ELIMINAZIONE CHAT ---------------------------------------------------------------------------------
    public void deleteChat(Long chatId){
        chatRepository.deleteById(chatId);
    }



}
