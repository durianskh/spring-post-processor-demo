package me.durianskh.demo.spring.service;

import me.durianskh.demo.spring.annotation.Greeting;

/**
 * Created by durianskh@gmail.com on 2020-03-06 10:52
 */
public interface HelloService {

    @Greeting("Hello Harold")
    String helloHarold();

    @Greeting("Hello Albert")
    String helloAlbert();
}
