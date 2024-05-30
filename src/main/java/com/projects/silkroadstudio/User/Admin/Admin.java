package com.projects.silkroadstudio.User.Admin;

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

    @Override
    public void setRole(Role role) throws IncorrectInformationProvidedException {
        if (role.getRole() != ERole.ROLE_ADMIN) {
            throw new IncorrectInformationProvidedException("Admin user must have admin role");
        }
        super.setRole(role);
    }

    public Admin(String name, String surname, String email, String password, Role role) throws IncorrectInformationProvidedException {
        super(name ,surname, email, password);
        setRole(role);
    }

    @Override
    public String toString() {
        return "Admin {id=" + super.getId() + ", name=" + super.getName() + ", surname=" + super.getSurname() + ", email=" + super.getEmail() + ", password=" + super.getPassword() + ", role=" + super.getRole() + "}";
    }

}
