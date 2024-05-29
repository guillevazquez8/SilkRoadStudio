package com.projects.silkroadstudio.User.Role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Setter
    @Enumerated(EnumType.STRING)
    private ERole role;

    public Role(ERole role) {
        this.role = role;
    }

}
