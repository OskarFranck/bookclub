package com.example.oskar.controller;

import com.example.oskar.model.UserModel;
import com.example.oskar.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/test")
    public String test() {
        logger.info("Hello");
        return "OK";
    }

    @GetMapping("/user/info")
    public UserModel getUserDetails() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("Apicontroller " + username);
        return userRepository.findByUsername(username).orElse(null);
    }
}
