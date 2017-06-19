package com.itra;

import com.itra.config.SecurityConfiguration;
import com.itra.config.WebConfiguration;
import com.itra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SecurityConfiguration.class, WebConfiguration.class})
public class DbCApplication {

    @Autowired
    public UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(DbCApplication.class, args);
    }

}