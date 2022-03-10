package com.acn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

   // Logger logger = LogManager.getLogger(this.getClass());

    private MessageService messageService; //hier kann man inject instances

    public GreetingServiceImpl() {
    }
@Autowired
    public GreetingServiceImpl(MessageService messageService) {
        this.messageService = messageService;
    }
    /*public GreetingServiceImpl(@Qualifier("MessageBean1") MessageService messageService) {
        this.messageService = messageService;
    }*/

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public String getGreeting(String addedText) {
        //logger.info("greeting success");
        return "Greeting from " + messageService.message() + addedText;
    }
}
