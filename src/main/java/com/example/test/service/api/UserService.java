package com.example.test.service.api;

import com.example.test.controller.dto.UserCreateRequest;
import com.example.test.controller.dto.UserRespond;
import com.example.test.entity.UserEntity;

public interface UserService {

    UserRespond createUser(UserCreateRequest userCreateRequest);

    UserEntity findUserEntity(Integer id);

    void approveUser(Integer id);
}
