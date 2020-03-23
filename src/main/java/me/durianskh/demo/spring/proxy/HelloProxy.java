package me.durianskh.demo.spring.proxy;

import me.durianskh.demo.spring.annotation.Greeting;
import org.apache.commons.lang3.ArrayUtils;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by durianskh@gmail.com on 2020-03-06 23:59
 */
public class HelloProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = 1918484219862662177L;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }

        Annotation[] annotations = method.getAnnotations();
        if (ArrayUtils.isEmpty(annotations)) {
            return null;
        }
        return Arrays.stream(annotations)
                .filter(annotation -> annotation instanceof Greeting)
                .map(annotation -> {
                    Greeting greeting = (Greeting) annotation;
                    return greeting.value();
                })
                .findFirst()
                .get();
    }
}
