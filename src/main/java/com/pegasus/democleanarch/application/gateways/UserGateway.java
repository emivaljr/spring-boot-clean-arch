package com.pegasus.democleanarch.application.gateways;

import com.pegasus.democleanarch.core.entities.User;

public interface UserGateway {
    User createUser(User user);
}
