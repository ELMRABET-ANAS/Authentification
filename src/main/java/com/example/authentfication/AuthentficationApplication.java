package com.example.authentfication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.example.authentfication.entities.AppRole;
import com.example.authentfication.service.AccountService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableEurekaClient
public class AuthentficationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthentficationApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AccountService accountService)
    {
        return args -> {
            accountService.save(new AppRole("CLIENT"));
            accountService.save(new AppRole("ADMIN"));
            accountService.save(new AppRole("AGENT"));
            Stream.of("user1", "user2" , "user3","admin").forEach(un->{
                accountService.saveUser(un,"1234","1234");
            });
            accountService.addRoleToUser("user1","CLIENT");
            accountService.addRoleToUser("user2","AGENT");
            accountService.addRoleToUser("user3","AGENT");
        };
    }
}
