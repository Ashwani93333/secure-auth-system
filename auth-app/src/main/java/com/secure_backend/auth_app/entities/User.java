package com.secure_backend.auth_app.entities;

import com.secure_backend.auth_app.entities.enums.Providers;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor // Making constructor with all fields
@NoArgsConstructor // making constructor with no fields
@Builder
//DB Table
@Entity
@Table(name = "users")
public class User {
    @Id
    //Auto generate UUID
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String name;
    @Column(unique = true)
    String email;
    String password;
    boolean active = true;
    Instant createdAt = Instant.now();
    Instant updatedAt = Instant.now();
    Providers provider = Providers.LOCAL;
    Set<Role> role = new HashSet<>();

}
