package com.projects.silkroadstudio.User.Role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(unique=true)
    private ERole role;

    public Role(ERole role) {
        this.role = role;
    }

}
