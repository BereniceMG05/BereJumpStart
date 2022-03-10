package com.acn;

import com.acn.config.SpringConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GreetingServiceImplJavaBasedTest {
    private static ApplicationContext ac;
    //private static GreetingService greetingService;

    @BeforeClass
    public static void setUp() throws Exception {
        //  greetingService = new GreetingServiceImpl(new MessageServiceImpl1());
        ac = new AnnotationConfigApplicationContext(SpringConfig.class);
    }

    @AfterClass
    public static void tearDown() throws Exception {
    }

    @Test
    public void getGreeting() {
        //   assertNotNull(greetingService);
        assertNotNull(ac);
        GreetingService greetingService = ac.getBean(GreetingService.class);
        String expectedGreeting = "Greeting from Spring 1 end";
        System.out.println(greetingService.getGreeting(" end"));
        assertEquals(expectedGreeting, greetingService.getGreeting(" end"));

    }
}
