package it.unife.ingsw202324.Chat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table (name = "message")
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    @Lob
    private String content;
    private Long senderId; // dall'API di Mockoon

    @Column(name = "timestamp", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timestamp;


    // --- Relazione Message-Chat ---
    // un messaggio è contenuto in una sola chat
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

}
