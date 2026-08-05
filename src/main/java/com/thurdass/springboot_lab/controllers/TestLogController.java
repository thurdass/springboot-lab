package com.thurdass.springboot_lab.controllers;

import com.thurdass.springboot_lab.services.PersonServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TestLogController {

    private Logger logger = Logger.getLogger(TestLogController.class.getName());

   @GetMapping("/test")
    public String testLog() {
        return "Logs generated successfully";
    }
}
