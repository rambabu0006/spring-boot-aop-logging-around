package com.example.log.demo.logback.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.log.demo.logback.helper.SpringLoggingHelper;

@Controller
public class LoggerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/login")
   // public String loggerMethod(HttpServletRequest request){
    public String loggerMethod(String name){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        new SpringLoggingHelper().helpMethod();
        return "index";
    }
}
