package com.projects.silkroadstudio;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Admin extends User {

    public Admin(String name, String surname, String email, String password, Role role) throws IncorrectInformationProvidedException {
        super(name ,surname, email, password, role);
    }

}
