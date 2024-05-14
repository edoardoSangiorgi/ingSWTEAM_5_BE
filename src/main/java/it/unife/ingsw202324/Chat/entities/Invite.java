package it.unife.ingsw202324.Chat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invite")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invite {

    @Id
    private Long id;

    private Long senderId;

    private String type;

    private String text;

}
