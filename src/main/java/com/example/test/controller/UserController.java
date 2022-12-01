package com.example.test.controller;


import com.example.test.controller.dto.UserCreateRequest;
import com.example.test.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.spring.annotations.StartProcess;
import org.camunda.bpm.engine.spring.annotations.StartTask;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new UserCreateRequest());
        return "user/new_user";
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("user") UserCreateRequest userCreateRequest){
        userService.createUser(userCreateRequest);
        return "redirect:/index";
    }

}
