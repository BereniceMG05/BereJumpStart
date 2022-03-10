package com.acn;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class GreetingServiceImplTest {
    private static ApplicationContext ac;
    //private static GreetingService greetingService;

    @BeforeClass
    public static void setUp() throws Exception {
      //  greetingService = new GreetingServiceImpl(new MessageServiceImpl1());
    ac = new ClassPathXmlApplicationContext("mybean.xml");
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