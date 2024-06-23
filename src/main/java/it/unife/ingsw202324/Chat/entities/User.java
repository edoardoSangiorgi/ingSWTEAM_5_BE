package it.unife.ingsw202324.Chat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String username;
    private String name;
    private String surname;
    private Integer tel;
    private Date birthDate;
    private Character gender;
    private boolean admin;

    @ManyToMany // TODO: mettere attributo di join
    private List<Chat> chats;

}
