package fr.cgs.cgs_back.dto;

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
}
