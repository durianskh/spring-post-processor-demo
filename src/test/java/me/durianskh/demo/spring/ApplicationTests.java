package me.durianskh.demo.spring;

import me.durianskh.demo.spring.service.CiaoService;
import me.durianskh.demo.spring.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


    @Autowired
    private HelloService helloService;

    @Autowired
    private CiaoService ciaoService;

    @Test
    public void helloServiceTest() {
        Assert.assertEquals("Hello Albert", helloService.helloAlbert());
        Assert.assertEquals("Hello Harold", helloService.helloHarold());
    }

    @Test
    public void hiServiceTest() {
        Assert.assertEquals("Hi James", ciaoService.hiJames());
        Assert.assertEquals("Hi Tomcat", ciaoService.hiTomcat());
    }
}
