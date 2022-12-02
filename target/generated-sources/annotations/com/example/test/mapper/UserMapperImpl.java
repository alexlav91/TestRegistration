package com.example.test.mapper;

import com.example.test.controller.dto.UserCreateRequest;
import com.example.test.controller.dto.UserRespond;
import com.example.test.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-02T00:50:45+0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserCreateRequest userCreateRequest) {
        if ( userCreateRequest == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setName( userCreateRequest.getName() );

        return userEntity;
    }

    @Override
    public UserRespond toRespond(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserRespond userRespond = new UserRespond();

        userRespond.setName( userEntity.getName() );

        return userRespond;
    }
}
