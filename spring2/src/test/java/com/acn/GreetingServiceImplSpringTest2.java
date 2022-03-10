package com.acn;

import com.acn.config.SpringConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class GreetingServiceImplSpringTest2 {
    @Autowired
    GreetingService greetingService;

    @Value("${spring.profiles.active}")
    String activeProfile;

    @BeforeClass
    public static void setUp() throws Exception {
    }

    @AfterClass
    public static void tearDown() throws Exception {
    }

    @Test
    public void getGreeting() {
        //berenice.muzquiz   //username
        assertNotNull(greetingService);
        String expectedGreeting = null;
        if (activeProfile.equals("dev")){
            expectedGreeting = "Greeting from Spring 1 end";
        } else if (activeProfile.equals("test")) {
            expectedGreeting = "Greeting from Spring 2 end";
        } else {
            expectedGreeting = "Greeting from berenice.muzquiz end";
        }
        System.out.println(greetingService.getGreeting(" end"));
        assertEquals(expectedGreeting, greetingService.getGreeting(" end"));
    }
}
