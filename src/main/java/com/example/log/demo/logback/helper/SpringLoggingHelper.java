package com.example.log.demo.logback.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringLoggingHelper {
    private final Logger logger = LoggerFactory.getLogger("analytics");
    public void helpMethod(){
        logger.debug("This is analytics a debug message");
        logger.info("This is  analytics an info message");
        logger.warn("This is a  analytics  warn message");
        logger.error("This is an   analytics error message");

    }
    
    
}