package com.pegasus.democleanarch.infraestructure.mappers;

import com.pegasus.democleanarch.core.entities.User;
import com.pegasus.democleanarch.infraestructure.persistence.UserEntity;

public class UserEntityMapper {
    public UserEntity toEntity(User userDomainObj) {
        return new UserEntity(userDomainObj.username(), userDomainObj.password(), userDomainObj.email());
    }

    public User toDomainObj(UserEntity userEntity) {
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
    }
}
