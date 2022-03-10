package com.acn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component("MessageBean1") @Lazy(false) @Scope("singleton")  // @Primary
public class MessageServiceImpl1 implements MessageService {
   // Logger logger = LogManager.getLogger(this.getClass());
    public MessageServiceImpl1() {
    }

    @Override
    public String message() {
       // logger.info("message 1 success");
        return "Spring 1";
    }
}
