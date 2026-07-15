package com.secure_backend.auth_app.services;


import com.secure_backend.auth_app.dtos.UserDto;
import com.secure_backend.auth_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

//    public UserDto createUser(UserDto userDto) {
//        if(userRepository.findByEmail(userDto.getEmail()).isPresent()) {
//            return null;
//        }
//
//    }
}
