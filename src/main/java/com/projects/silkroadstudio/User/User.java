package com.projects.silkroadstudio.User;

import com.projects.silkroadstudio.IncorrectInformationProvidedException;
import com.projects.silkroadstudio.Role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    @ManyToOne
    private Role role;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) throws IncorrectInformationProvidedException {
        if (!email.contains("@")) {
            throw new IncorrectInformationProvidedException("Email provided is incorrect, please provide the right email");
        }
        this.email = email;
    }

    public void setPassword(String password) throws IncorrectInformationProvidedException {
        if (password.length() < 10) {
            throw new IncorrectInformationProvidedException("Your password is too short");
        }
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String name, String surname, String email, String password, Role role) throws IncorrectInformationProvidedException {
        this.name = name;
        this.surname = surname;
        setEmail(email);
        setPassword(password);
        this.role = role;
    }

}
