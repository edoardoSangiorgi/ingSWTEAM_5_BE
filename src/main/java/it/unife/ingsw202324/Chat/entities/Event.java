package it.unife.ingsw202324.Chat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity( name = "EVENT" )
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    private String name;
    private String description;
    private String type;
    private Integer minAge;
    private String loc;
    private LocalDateTime start;
    private LocalDateTime end;

    @OneToOne
    private Chat chat;

}
