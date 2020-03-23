package me.durianskh.demo.spring.annotation;

import me.durianskh.demo.spring.processor.HelloScannerConfigurerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by durianskh@gmail.com on 2020-03-06 11:16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(HelloScannerConfigurerRegistrar.class)
public @interface HelloScan {

    String basePackage();
}
