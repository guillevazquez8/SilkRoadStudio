package com.projects.silkroadstudio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

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

    public User(String name, String surname, String email, String password) throws IncorrectInformationProvidedException {
        this.name = name;
        this.surname = surname;
        setEmail(email);
        setPassword(password);
    }

    public User(String email, String password) throws IncorrectInformationProvidedException {
        setEmail(email);
        setPassword(password);
    }
}
