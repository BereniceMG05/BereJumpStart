package com.acn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component@Profile("test")
public class MessageServiceImpl2 implements  MessageService{
   // Logger logger = LogManager.getLogger(this.getClass());
    public MessageServiceImpl2() {
    }

    @Override
    public String message() {
      //  logger.info("message 2 success");
        return "Spring 2";
    }
}
