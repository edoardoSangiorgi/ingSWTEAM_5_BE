package it.unife.ingsw202324.Chat.controller;

import it.unife.ingsw202324.Chat.entities.Chat;
import it.unife.ingsw202324.Chat.entities.Message;
import it.unife.ingsw202324.Chat.entities.User;
import it.unife.ingsw202324.Chat.entities.Invite;
import it.unife.ingsw202324.Chat.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController /* Annotation per definire che la classe risponderà tramite rest  */
@RequestMapping("/api") /* Annotation per definire il path della classe  */
public class MainController {

    // --- I N S T A N C E S  D E C L A R A T I O N -------------------------------------
    UserService userService;
    ChatService chatService;
    MessageService messageService;

    InviteService inviteService;


    // --- U S E R  A P I  --------------------------------------------------------------------------

    @GetMapping("/user") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/user")
    public List<User> addElements(List<User> users) {
        userService.addUsers(users);            // richiede la cancellazinoe del record
        return this.getAllUsers();              // richiede la nuova lista aggiornata di record

    }

    @DeleteMapping("/user")
    public List<User> deleteElements(List<User> users){
        userService.deleteUsers(users);          // richiede la cancellazinoe del record
        return this.getAllUsers();               // richiede la nuova lista aggiornata di record
    }


    // --- C H A T  A P I ------------------------------------------------------------------------------
    @GetMapping("/chat")
    public List<Chat> getAllChats(){
        return chatService.getAll();
    }


    @PostMapping("/chat")
    public List<Chat> addChat(Chat chat){
        chatService.addChat(chat);
        return this.getAllChats();
    }


    @DeleteMapping("/chat")
    public List<Chat> deleteChat(Chat chat){
        chatService.deleteChat(chat);
        return this.getAllChats();
    }


    @PatchMapping("/chat")
    public List<Chat> updateChat(Chat chat){
        chatService.update(chat);
        return this.getAllChats();
    }



    // --- M E S S A G E  A P I --------------------------------------------------------------------

    @GetMapping("/message")
    public List<Message> getMessages(){
        return messageService.getAll();
    }


    @PostMapping("/message")
    public List<Message> addMessage(Message message){
        messageService.addMessages(message);
        return this.messageService.getAll();
    }


    @DeleteMapping("/message")
    public List<Message> deleteMessage(List<Message> messages){
        messageService.deleteMessages(messages);
        return this.messageService.getAll();
    }


    @PatchMapping("/message")
    public List<Message> updateMessage(Message message){
        messageService.update(message);
        return this.messageService.getAll();
    }



    // --- I N V I T E  A P I  --------------------------------------------------------------------

    // still working...
    @GetMapping("/invite")
    public List<Invite> getInvites(){
        return inviteService.getAll();
    }

    @PatchMapping("/invite")
    public List<Invite> updateInvite(List<Invite> invites) {
        inviteService.update(invites);
        return this.getInvites();
    }

    // --- R E S T  A P I ---------------------------------------------------------------------------
    @RequestMapping("/callREST") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRest() {
        return TemplateRestConsumer.callREST("helloMock", null, true);
    }

}
