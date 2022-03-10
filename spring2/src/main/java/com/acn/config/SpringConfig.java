package com.acn.config;

import com.acn.MessageService;
import com.acn.MessageServiceImpl1;
import com.acn.MessageServiceImpl3;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.acn")
@EnableAspectJAutoProxy
public class SpringConfig {   // creation of a bean from outside
    @Profile("dev")
    @Bean(name = "Message1Bean") @Scope("singleton") @Lazy(value = false)
    public MessageService getMessage1() {
        return new MessageServiceImpl1();
    }
    @Bean(name = "Message3Bean") @Scope("singleton") @Lazy(value = false)
    public MessageService getMessage3() {
        return new MessageServiceImpl3();
    }
}
