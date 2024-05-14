package it.unife.ingsw202324.Chat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// --- M O D E L L O  D E L L A  T A B E L L A  U S E R ---


@Entity                 // questa classe è un entity bean
@Table(name = "user")   // mappa una tabella fisica nominata 'user'
@Data
@AllArgsConstructor     // i costruttori sono generici e auto-creati dal plughin lombok
@NoArgsConstructor      // lombok creerà anche i getter e i setter
public class User {

    @Id // Annotation per definire la primary key della tabella
    private Long id;

    private String name;

    private String tel;

}
