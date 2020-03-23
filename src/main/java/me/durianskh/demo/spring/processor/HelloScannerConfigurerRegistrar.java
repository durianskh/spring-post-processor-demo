package me.durianskh.demo.spring.processor;

import me.durianskh.demo.spring.annotation.HelloScan;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by durianskh@gmail.com on 2020-03-06 15:10
 */
public class HelloScannerConfigurerRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(HelloScan.class.getName()));
        if (attributes != null) {
            registerBeanDefinitions(attributes, registry, generateBaseBeanName(importingClassMetadata, 0));
        }
    }

    private static String generateBaseBeanName(AnnotationMetadata importingClassMetadata, int index) {
        return importingClassMetadata.getClassName() + "#" + HelloScannerConfigurerRegistrar.class.getSimpleName() + "#" + index;
    }

    private void registerBeanDefinitions(AnnotationAttributes attributes, BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(HelloScannerConfigurer.class);
        builder.addPropertyValue("basePackage", attributes.getString("basePackage"));
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }
}
