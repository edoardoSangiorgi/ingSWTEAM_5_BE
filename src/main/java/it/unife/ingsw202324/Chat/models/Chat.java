package it.unife.ingsw202324.Chat.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String members;

    private String state;

    private String info;
}
