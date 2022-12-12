package com.projects.silkroadstudio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    private ERole role;

    public void setRole(ERole role) {
        this.role = role;
    }

    public Role(ERole role) {
        this.role = role;
    }

}
