package com.example.test.service.impl;

import com.example.test.controller.dto.UserCreateRequest;
import com.example.test.controller.dto.UserRespond;
import com.example.test.entity.UserEntity;
import com.example.test.mapper.UserMapper;
import com.example.test.repository.UserRepository;
import com.example.test.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.spring.annotations.StartProcess;
import org.camunda.bpm.engine.spring.annotations.StartTask;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    @StartProcess(processKey = )
    public UserRespond createUser(UserCreateRequest userCreateRequest) {
        UserEntity userEntity = userMapper.toEntity(userCreateRequest);
        return userMapper.toRespond(userRepository.save(userEntity));
    }
}
