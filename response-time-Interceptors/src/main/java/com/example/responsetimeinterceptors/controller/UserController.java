package com.example.responsetimeinterceptors.controller;

import com.example.responsetimeinterceptors.model.User;
import com.example.responsetimeinterceptors.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/getList")
    public List<User> getUserList() {
        return userRepository.findAll();
    }

}
