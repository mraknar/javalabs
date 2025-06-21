package com.mraknar.config;

import com.mraknar.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<User> users() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "odazai", "Osamu", "Dazai"));
        userList.add(new User(2, "ezurcher", "Erick", "Zurcher"));
        userList.add(new User(3, "vbartol", "Vladimir", "Bartol"));

        return userList;
    }
}
