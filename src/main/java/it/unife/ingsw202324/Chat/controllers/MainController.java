package it.unife.ingsw202324.Chat.controllers;

import it.unife.ingsw202324.Chat.DTOs.ChatDTO;
import it.unife.ingsw202324.Chat.DTOs.EventDTO;
import it.unife.ingsw202324.Chat.DTOs.MessageDTO;
import it.unife.ingsw202324.Chat.DTOs.UserDTO;
import it.unife.ingsw202324.Chat.entities.Message;
import it.unife.ingsw202324.Chat.services.ChatService;
import it.unife.ingsw202324.Chat.services.MessageService;
import it.unife.ingsw202324.Chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private MessageService messageService;
    @Autowired
    UserService userService;


    // -- RICERCA UTENTI -----------------------------------------------------------------------
    @GetMapping("/users")
    public List<UserDTO> getUsers(@RequestBody UserDTO userDTO){
        // TODO: mockoon api --> TemplateRestConsumer
        return null;
    }

    // -- RICERCA EVENTO -----------------------------------------------------------------------
    @GetMapping("/events")
    public List<EventDTO> getEvents(@RequestBody EventDTO eventDTO){
        // TODO: mockoon api --> TemplateRestConsumer
        return null;
    }


    // -- CREAZIONE NUOVA CHAT ------------------------------------------------------------------
    @PostMapping("/chats")
    public List<ChatDTO> createChat(@RequestBody ChatDTO request) {
        /*
        * INPUT:
        *           request:    un oggetto che contiente tutte le informazioni della chat da creare
        *           CreateChatRequest
        *
        * COSA FA:
        *           - invoca un servizio per creare una nuova chat
        *           - ritorna la lista aggiornata delle chat (una lista di ChatDTO)
        * */
        chatService.createChat(request);
        return chatService.getAll();
    }


    // -- LETTURA LISTA CHAT ----------------------------------------------------------------------
    @GetMapping("/chats")
    public List<ChatDTO> getChatLlist(){
        /*
        * COSA FA:
        *           restituisce una lista di ChatDTO al client
        *           di fatto la lista di tutte le chat
        *
        * */
        return chatService.getAll();
    }


    // -- LETTURA SINGOLA CHAT ----------------------------------------------------------------------
    @GetMapping("/chats/{name}")
    public ChatDTO getChat(@PathVariable ChatDTO chatDTO) {
        /*
        * INPUT:
        *           id:     indentificativo della chat specifica
        *           Long
        *
        * COSA FA:
        *           Mostra informazioni riguardo una chat specifica:
        *               - messaggi (oggetti messaggio)
        *               - membri
        *               - data creazione
        *               - ...
        *
        * ALTRE INFO:
        *           È chiamata quando un utente clicca sulla chat
        *           Si apre quindi la schermata dei messaggi
        *           Nel caso l'utente voglia visualizzare altre informazioni esse sono gia presenti nel client
        *           e saranno visualizzate in una pagina apposita
        * */
        return chatService.getChat(chatDTO);

    }


    // -- INVIO MESSAGGIO ---------------------------------------------------------------------------
    @PostMapping("/chat/message")
    public void createMessage(@RequestBody MessageDTO request, Long chatId) {
        /*
            riceve le chiamate di TUTTI gli UTENTI!

            alla view viene restituito solo il nuovo messaggio
            la quale fa l'append alla lista relativa alla chat (memorizzata sulla view)
        */
        Message convertedMessage = new Message();
        convertedMessage = messageService.convertFromDTO(request);

        messageService.createMessage(convertedMessage, chatId);
    }

}
