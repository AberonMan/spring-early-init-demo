package ru.sber.demo.dsl.pockemon;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.Ordered;

import java.util.Arrays;

public abstract class AbstractPockemonDslBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Arrays.stream(
            beanFactory.getBeanNamesForType(PockemonDsl.class, false, false)
        ).forEach(dslBeanName -> registerBeans((BeanDefinitionRegistry) beanFactory, dslBeanName));
    }
    
    private void registerBeans(BeanDefinitionRegistry beanFactory, String dslBeanName) {
        String pockemonName = dslBeanName.replace("Dsl", "");
        registerPockemon(beanFactory, dslBeanName, pockemonName);
        registerMaster(beanFactory, dslBeanName, "master-for-" + dslBeanName, pockemonName);
    }
    
    protected abstract void registerPockemon(BeanDefinitionRegistry beanFactory, String dslBeanName, String pockemonName);
    
    protected abstract void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                           String pockemonName);
    
    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
