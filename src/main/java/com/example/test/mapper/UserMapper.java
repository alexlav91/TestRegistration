package com.example.test.mapper;

import com.example.test.config.MappersConfig;
import com.example.test.controller.dto.UserCreateRequest;
import com.example.test.controller.dto.UserRespond;
import com.example.test.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MappersConfig.class)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", ignore = true)
    UserEntity toEntity(UserCreateRequest userCreateRequest);

    UserRespond toRespond(UserEntity userEntity);
}
