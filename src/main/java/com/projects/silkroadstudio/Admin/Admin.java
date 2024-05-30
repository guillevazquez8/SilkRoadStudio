package com.projects.silkroadstudio.Admin;

import com.projects.silkroadstudio.User.Role.ERole;
import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import com.projects.silkroadstudio.User.Role.Role;
import com.projects.silkroadstudio.User.User;
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

    public Admin(String name, String surname, String email, String password) throws IncorrectInformationProvidedException {
        super(name ,surname, email, password);
        setRole(new Role(ERole.ROLE_ADMIN));
    }

}
