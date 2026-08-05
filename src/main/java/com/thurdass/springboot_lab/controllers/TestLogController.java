package com.thurdass.springboot_lab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

   @GetMapping("/test")
    public String testLog() {
       logger.debug("This is DEBUG log");
       logger.info("This is INFO log");
       logger.warn("This is WARN log");
       logger.error("This is error log");
        return "Logs generated successfully";
    }
}
