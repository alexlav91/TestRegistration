package com.example.test.service.camunda;

import com.example.test.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApproveRegistration implements JavaDelegate {

    private final UserService userService;

    private final String SUCCESS_REGISTRATION_MESSAGE = "[%s] Пользователь %s успешно зарегестрирован";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Long id = (Long)delegateExecution.getVariable("userId");

        userService.approveUser(id);

        System.out.println(String.format(SUCCESS_REGISTRATION_MESSAGE,
                ApproveRegistration.class.getName(),
                delegateExecution.getVariable("username")));

    }
}
