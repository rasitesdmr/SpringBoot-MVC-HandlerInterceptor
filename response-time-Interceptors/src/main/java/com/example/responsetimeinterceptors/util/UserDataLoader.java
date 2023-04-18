package com.example.responsetimeinterceptors.util;

import com.example.responsetimeinterceptors.model.User;
import com.example.responsetimeinterceptors.repository.UserRepository;
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

        for (int i = 0 ; i<60000 ;i++){
            User user = new User();
            user.setUsername("A");
            user.setEmail("A@gmail.com");
            userRepository.save(user);
        }
    }
}
