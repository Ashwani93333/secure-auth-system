package com.secure_backend.auth_app.dtos;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {
    UUID id ;
    String name;
}
