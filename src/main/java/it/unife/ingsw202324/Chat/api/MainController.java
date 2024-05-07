package it.unife.ingsw202324.Chat.api;

import it.unife.ingsw202324.Chat.models.User;
import it.unife.ingsw202324.Chat.services.UserService;
import it.unife.ingsw202324.Chat.services.TemplateRestConsumer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /* Annotation per definire che la classe risponderà tramite rest  */
@RequestMapping("/api") /* Annotation per definire il path della classe  */
public class MainController {

    // --- I N S T A N C E S  D E C L A R A T I O N ---
    UserService userService;


    // --- U S E R  A P I  ---
    @RequestMapping("/getAllUsers") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping("/addUsers")
    public List<User> addElements(List<User> users) {
        userService.addUsers(users);            // richiede la cancellazinoe del record
        return this.getAll();                   // richiede la nuova lista aggiornata di record

    }

    @RequestMapping("/deleteUsers")
    public List<User> deleteElements(List<User> users){
        userService.deleteUsers(users);          // richiede la cnacellazinoe del record
        return this.getAll();                   // richiede la nuova lista aggiornata di record
    }

    @RequestMapping("/callREST") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRest() {
        return TemplateRestConsumer.callREST("helloMock", null, true);
    }

}
