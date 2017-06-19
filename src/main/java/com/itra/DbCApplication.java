package com.itra;

import com.itra.authentication.model.UserRole;
import com.itra.config.SecurityConfiguration;
import com.itra.config.WebConfiguration;
import com.itra.entity.models.User;
import com.itra.entity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Import({SecurityConfiguration.class, WebConfiguration.class})
public class DbCApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbCApplication.class, args);
    }

//    @Bean
//    CommandLineRunner bootstrap(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
//        return (args) -> {
//            userRepository.save(
//                    new User("Peter", passwordEncoder.encode("password"), UserRole.ADMIN)
//            );
//
//            userRepository.save(
//                    new User("John", passwordEncoder.encode("password"), UserRole.DEVELOPER)
//            );
//
//            userRepository.findAll().stream().map(User::toString).forEach(System.out::println);
//        };
//    }
}
