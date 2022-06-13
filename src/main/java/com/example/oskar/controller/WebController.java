package com.example.oskar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/page")
    public String landingPage() {
        logger.info("Hej");
        return "landingpage";
    }

    @GetMapping("/index")
    public String index() {
        logger.info("Hej");
        return "index";
    }

}
