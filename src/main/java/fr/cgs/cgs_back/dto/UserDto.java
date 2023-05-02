package fr.cgs.cgs_back.dto;

import fr.cgs.cgs_back.entity.User;

public class UserDto {

    private int id;
    private String nickname;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private int role;

    public UserDto(int id, String nickname, String email, String password, String firstname, String lastname, int role) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.role = user.getRole();
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getRole() {
        return role;
    }

}
