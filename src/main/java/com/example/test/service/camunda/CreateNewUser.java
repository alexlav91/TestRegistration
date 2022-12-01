package com.example.test.service.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CreateNewUser implements JavaDelegate {

    private final String SUCCESS_REGISTRATION_MESSAGE = "[%s] Пользователь %s успешно зарегестрирован";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println(String.format(SUCCESS_REGISTRATION_MESSAGE,
                CreateNewUser.class.getName(),
                delegateExecution.getVariable("username")));

    }
}
