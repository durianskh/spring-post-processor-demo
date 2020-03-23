package me.durianskh.demo.spring.processor;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * Created by durianskh@gmail.com on 2020-03-06 11:07
 */
public class HelloScanner extends ClassPathBeanDefinitionScanner {

    private Class<? extends HelloFactoryBean> helloFactoryBeanClass = HelloFactoryBean.class;

    public HelloScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    public void registerFilters() {
        addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        beanDefinitionHolders.stream()
                .map(beanDefinitionHolder -> (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition())
                .forEach(definition -> {
                    definition.getConstructorArgumentValues().addGenericArgumentValue(definition.getBeanClassName());
                    definition.setBeanClass(this.helloFactoryBeanClass);
                    definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
                    definition.setLazyInit(false);
                });
        return beanDefinitionHolders;
    }
}
