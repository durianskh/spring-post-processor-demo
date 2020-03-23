package me.durianskh.demo.spring.processor;

import me.durianskh.demo.spring.proxy.HelloProxy;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * Created by durianskh@gmail.com on 2020-03-06 22:28
 */
public class HelloFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;

    public HelloFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, new HelloProxy<T>());
    }

    @Override
    public Class<?> getObjectType() {
        return this.mapperInterface;
    }
}