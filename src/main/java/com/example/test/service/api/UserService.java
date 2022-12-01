package com.example.test.service.api;

import com.example.test.controller.dto.UserCreateRequest;
import com.example.test.controller.dto.UserRespond;

public interface UserService {

    UserRespond createUser(UserCreateRequest userCreateRequest);
}
