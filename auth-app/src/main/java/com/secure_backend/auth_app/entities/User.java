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
    @Column(name = "user_id")
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
    @Enumerated(EnumType.STRING)
    Providers provider = Providers.LOCAL;

    // Role and User DB relations
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name = "role_id")  )
    Set<Role> role = new HashSet<>();

    //Entity lifecycle
    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        if(createdAt == null)
            createdAt = now;
        updatedAt = now;
    }


    //to update
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }


    /*
Lifecycle of JPA entity
@PrePersist
create entity
@PostPersist

@PreUpdate
change in entity state
@PostUpdate

@PreRemove
delete entity
@PostRemove

@PostLoad
    * */
}
