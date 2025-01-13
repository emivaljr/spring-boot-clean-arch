package com.pegasus.democleanarch.infraestructure.mappers;

import com.pegasus.democleanarch.core.entities.User;
import com.pegasus.democleanarch.infraestructure.controllers.dto.CreateUserRequest;
import com.pegasus.democleanarch.infraestructure.controllers.dto.CreateUserResponse;

public class UserDTOMapper {
    public CreateUserResponse toResponse(User user) {
        return new CreateUserResponse(user.username(), user.email());
    }

    public User toUser(CreateUserRequest request) {
        return new User(request.username(), request.password(), request.email());
    }
}
