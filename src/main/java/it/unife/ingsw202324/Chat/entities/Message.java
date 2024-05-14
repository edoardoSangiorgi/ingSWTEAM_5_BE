package it.unife.ingsw202324.Chat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "message")

public class Message {

    @Id
    private Long id;

    private Long idChat;

    private Long idUser;

    private String text;

}
