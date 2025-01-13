package com.pegasus.democleanarch.infraestructure.gateways;

import com.pegasus.democleanarch.application.gateways.UserGateway;
import com.pegasus.democleanarch.core.entities.User;
import com.pegasus.democleanarch.infraestructure.mappers.UserEntityMapper;
import com.pegasus.democleanarch.infraestructure.persistence.UserEntity;
import com.pegasus.democleanarch.infraestructure.persistence.UserRepository;


public class UserRepositoryGatewayImpl implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGatewayImpl(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        UserEntity savedEntity = userRepository.save(userEntity);

        return userEntityMapper.toDomainObj(savedEntity);
    }
}
