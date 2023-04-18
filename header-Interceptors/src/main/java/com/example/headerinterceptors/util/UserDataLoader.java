package com.example.headerinterceptors.util;

import com.example.headerinterceptors.model.User;
import com.example.headerinterceptors.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User();
        user1.setUsername("rasitesdmr");
        user1.setEmail("marasitesdmr@gmail.com");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("burhankvk");
        user2.setEmail("burhankvk@gmail.com");
        userRepository.save(user2);
    }
}
