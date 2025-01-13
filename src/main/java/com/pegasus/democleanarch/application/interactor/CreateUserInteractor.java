package com.pegasus.democleanarch.application.interactor;

import com.pegasus.democleanarch.application.gateways.UserGateway;
import com.pegasus.democleanarch.application.usecases.CreateUserUseCase;
import com.pegasus.democleanarch.core.entities.User;

public class CreateUserInteractor implements CreateUserUseCase{

    private final UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User create(User user) {
        return userGateway.createUser(user);
    }
}
