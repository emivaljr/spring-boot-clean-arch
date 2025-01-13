package com.pegasus.democleanarch.infraestructure.config;

import com.pegasus.democleanarch.application.gateways.UserGateway;
import com.pegasus.democleanarch.application.interactor.CreateUserInteractor;
import com.pegasus.democleanarch.application.usecases.CreateUserUseCase;
import com.pegasus.democleanarch.infraestructure.mappers.UserEntityMapper;
import com.pegasus.democleanarch.infraestructure.gateways.UserRepositoryGatewayImpl;
import com.pegasus.democleanarch.infraestructure.mappers.UserDTOMapper;
import com.pegasus.democleanarch.infraestructure.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CreateUserUseCase createUserCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGatewayImpl(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}
