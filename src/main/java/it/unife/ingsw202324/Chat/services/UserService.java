package it.unife.ingsw202324.Chat.services;

import it.unife.ingsw202324.Chat.DTOs.UserDTO;
import it.unife.ingsw202324.Chat.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDTO convertToDTO(User user){

        UserDTO newUserDTO = new UserDTO();

        newUserDTO.setUsername(user.getUsername());
        newUserDTO.setName(user.getName());
        newUserDTO.setSurname(user.getSurname());
        newUserDTO.setAdmin(user.isAdmin());
        newUserDTO.setTel(user.getTel());

        newUserDTO.setBirthDate(user.getBirthDate());
        newUserDTO.setGender(user.getGender());

        return newUserDTO;
    }

    public User convertFromDTO(UserDTO userDTO){

        User convertedUser = new User();

        convertedUser.setUsername(userDTO.getUsername());
        convertedUser.setName(userDTO.getName());
        convertedUser.setSurname(userDTO.getSurname());
        convertedUser.setAdmin(userDTO.isAdmin());
        convertedUser.setTel(userDTO.getTel());

        convertedUser.setBirthDate(userDTO.getBirthDate());
        convertedUser.setGender(userDTO.getGender());

        return convertedUser;
    }
}
