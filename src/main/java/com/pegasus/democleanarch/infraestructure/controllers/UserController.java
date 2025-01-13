package com.pegasus.democleanarch.infraestructure.controllers;

import com.pegasus.democleanarch.application.usecases.CreateUserUseCase;
import com.pegasus.democleanarch.core.entities.User;
import com.pegasus.democleanarch.infraestructure.controllers.dto.CreateUserRequest;
import com.pegasus.democleanarch.infraestructure.controllers.dto.CreateUserResponse;
import com.pegasus.democleanarch.infraestructure.mappers.UserDTOMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserUseCase createUserUseCase,
                          UserDTOMapper userDTOMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        User userBusinessObj = userDTOMapper.toUser(request);
        User user = createUserUseCase.create(userBusinessObj);
        return userDTOMapper.toResponse(user);
    }
}
