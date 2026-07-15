package com.secure_backend.auth_app.dtos;

import com.secure_backend.auth_app.entities.Role;
import com.secure_backend.auth_app.entities.enums.Providers;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    UUID id;
    String name;
    String email;
    String password;
    boolean active = true;
    Instant createdAt = Instant.now();
    Instant updatedAt = Instant.now();
    Providers provider = Providers.LOCAL;
    Set<Role> role = new HashSet<>();
}
