package it.unife.ingsw202324.Chat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {

    private Long id;
    private String chatName;
    private String type;
    private String state;

    private List<UserDTO> members;
    private List<MessageDTO> messages;
    private List<EventDTO> event;

}