package com.tmc.paca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class UserApiForTmcApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiForTmcApplication.class, args);
    }

}
