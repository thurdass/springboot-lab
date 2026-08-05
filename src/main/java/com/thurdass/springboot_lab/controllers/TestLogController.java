package com.thurdass.springboot_lab.controllers;

import com.thurdass.springboot_lab.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

   @GetMapping("/test")
    public String testLog() {
       logger.info("This is INFO log");
       logger.warn("This is WARN log");

        return "Logs generated successfully";
    }
}
