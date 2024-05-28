package it.unife.ingsw202324.Chat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

    private String content;
    private Long senderId;
    private Long chatId;

}
