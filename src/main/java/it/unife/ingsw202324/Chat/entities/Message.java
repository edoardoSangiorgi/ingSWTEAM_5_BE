package it.unife.ingsw202324.Chat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table (name = "MESSAGE")
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    /*
        ATTRIBUTI:
            - ID
            - contenuto
            - timestamp
            - mittente --> mock
            - chat di appartenenza
     */

    @Id
    private Long id;
    private String content;
    private LocalDateTime timestamp;
    private Long chatId;

    @ManyToOne
    private User sender;


}
