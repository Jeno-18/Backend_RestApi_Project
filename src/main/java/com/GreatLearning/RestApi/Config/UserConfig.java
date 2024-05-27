package com.GreatLearning.RestApi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.GreatLearning.RestApi.Entity.User;


@Configuration
public class UserConfig {

    @Bean
    public User user() {
        return new User();
    }
}

