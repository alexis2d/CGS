package fr.cgs.cgs_back.dto;

import fr.cgs.cgs_back.entity.User;

public class UserDto {

    private String email;
    private String password;


    public UserDto(int id, String nickname, String email, String password, String firstname, String lastname, int role) {
        this.email = email;
        this.password = password;
    }

    public UserDto(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }



}
