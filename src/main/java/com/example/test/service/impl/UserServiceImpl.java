package com.example.test.service.impl;

import com.example.test.exceptions.UserNotFoundException;
import com.example.test.controller.dto.UserCreateRequest;
import com.example.test.controller.dto.UserRespond;
import com.example.test.entity.UserEntity;
import com.example.test.mapper.UserMapper;
import com.example.test.repository.UserRepository;
import com.example.test.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RuntimeService runtimeService;

    private final UserMapper userMapper;

    @Override
    public UserRespond createUser(UserCreateRequest userCreateRequest) {
        UserEntity userEntityForSave = userMapper.toEntity(userCreateRequest);
        UserEntity userEntity = userRepository.save(userEntityForSave);
        Map<String, Object> variable = new HashMap<>();
        runtimeService.createMessageCorrelation("UserRegistered")
                .setVariable("username", userEntity.getName())
                .setVariable("userId", userEntity.getId())
                .correlate();
        return userMapper.toRespond(userEntity);
    }

    @Override
    public UserEntity findUserEntity(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()->
                UserNotFoundException.createById(id));
        return userEntity;
    }

    @Override
    public void approveUser(Long id) {
        UserEntity userEntity = findUserEntity(id);
        userEntity.setApproved(true);
        userRepository.save(userEntity);
    }
}
