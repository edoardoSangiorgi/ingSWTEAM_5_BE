package it.unife.ingsw202324.Chat.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {

    private String chatName;
    private List<Long> memberIds;

}
