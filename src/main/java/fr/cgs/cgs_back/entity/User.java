package fr.cgs.cgs_back.entity;

import fr.cgs.cgs_back.enumeration.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_nickname")
    private String nickname;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_firstname")
    private String firstname;

    @Column(name = "user_lastname")
    private String lastname;

    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private Roles role;

    @Column(name = "user_token")
    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    // Récupération du login
    @Override
    public String getUsername() {
        return email;
    }

    // Permet de savoir si l'utilisateur n'a pas expiré
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Permet de savoir si le compte de l'utilisateur n'a pas été bloqué
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Permet de savoir si l'utilisateur doit renouveller son mot de passe
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Permet de savoir si l'utilisateur est autorisé à s'authentifier (confirmation du compte)
    @Override
    public boolean isEnabled() {
        return true;
    }

    /* Getter et Setter */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
