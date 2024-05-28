package it.unife.ingsw202324.Chat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {

    private Long chatId;
    private String chatName;
    private String type;
    private String state;

    private List<Long> memberIds;
    private List<MessageDTO> messages;

}