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
    private Long id;
    private String name;
    private String type;

    private String state;

    private Date creationDate;

    @OneToOne
    private Event event;

    @ManyToMany
    private List<User> members;

    @OneToMany
    private List<Message> messages;



}

