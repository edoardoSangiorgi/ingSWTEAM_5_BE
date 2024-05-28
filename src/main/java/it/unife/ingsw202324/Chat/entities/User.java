package it.unife.ingsw202324.Chat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

// --- M O D E L L O  D E L L A  T A B E L L A  U S E R ---


@Entity                 // questa classe è un entity bean
@Table(name = "user")   // mappa una tabella fisica nominata 'user'
@Data
@AllArgsConstructor     // i costruttori sono generici e auto-creati dal plughin lombok
@NoArgsConstructor      // lombok creerà anche i getter e i setter
public class User {

    @Id // Annotation per definire la primary key della tabella
    private Long userId;
    private String username;
    private String nome;
    private String cognome;
    private String tel;
    private String bio;

    // --- USER-CHAT ---
    // un utente più essere membro di più chat
    @ManyToMany(mappedBy = "users")
    private List<Chat> chats = new ArrayList<>();

    // --- USER-MESSAGE ---
    // un utente può inviare più messaggi
    @OneToMany(mappedBy = "sender")
    private List<Message> messages = new ArrayList<>();

}
