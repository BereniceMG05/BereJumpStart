package com.acn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Component
//@Primary
//@Profile("dev")
public class MessageServiceImpl3 implements MessageService{
   // Logger logger = LogManager.getLogger(this.getClass());
@Value("${user.name}") //
  private String name;

    @Override
    public String message() {
       // logger.info("message 3 success");
        return  name;
    }
}
