package me.durianskh.demo.spring.annotation;

import java.lang.annotation.*;

/**
 * Created by durianskh@gmail.com on 2020-03-06 10:49
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Mapper {
}
