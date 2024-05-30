package com.projects.silkroadstudio.User;

import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import com.projects.silkroadstudio.User.Role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Setter
    private String name;

    @Setter
    private String surname;

    private String email;

    private String password;

    @ManyToOne
    @Setter
    private Role role;

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

}
