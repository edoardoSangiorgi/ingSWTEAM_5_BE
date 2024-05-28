package it.unife.ingsw202324.Chat.DTOs;

import it.unife.ingsw202324.Chat.entities.Chat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private Long id;

    private String content;
    private Long senderId;
    private LocalDateTime timestamp;

    private Chat chat;
}
