package it.unife.ingsw202324.Chat.controllers;

import it.unife.ingsw202324.Chat.DTOs.ChatDTO;
import it.unife.ingsw202324.Chat.DTOs.ChatRequest;
import it.unife.ingsw202324.Chat.DTOs.MessageRequest;
import it.unife.ingsw202324.Chat.DTOs.MessageDTO;
import it.unife.ingsw202324.Chat.services.ChatService;
import it.unife.ingsw202324.Chat.services.MessageService;
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


    // -- CREAZIONE NUOVA CHAT --
    @PostMapping("/chats")
    public List<ChatDTO> createChat(@RequestBody ChatRequest request) {
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


    // -- LEGGE LISTA CHAT --
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


    // -- LEGGE SINGOLA CHAT --
    @GetMapping("/chats/{id}")
    public ChatDTO getChat(@PathVariable Long id) {
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
        return chatService.getChat(id);
        // TODO: verificare se insieme alla chat legge anche i messaggi ad essa collegati
    }


    // -- INVIA MESSAGGIO --
    @PostMapping("/chat/message")
    public MessageDTO createMessage(@RequestBody MessageRequest request) {
        return messageService.createMessage(request);
    }
}
