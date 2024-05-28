package it.unife.ingsw202324.Chat.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;

// --- M O D E L L O  D E L L A  T A B E L L A  C H A T ---
@Entity
@Table (name = "chat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    private Long chatId;

    private String chatName;

    private String type;

    private String state;


    // --- CHAT-USER ---
    // una chat può avere più utenti
    @ElementCollection
    private List<Long> memberIds;  // Lista di utenti da Mockoon


    // --- CHAT-MESSAGE ---
    // una chat può avere più messaggi
    @OneToMany
    private List<Message> messages;


}

