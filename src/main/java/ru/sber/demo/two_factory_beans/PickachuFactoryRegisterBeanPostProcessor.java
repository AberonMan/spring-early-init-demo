package ru.sber.demo.two_factory_beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.Ordered;

public class PickachuFactoryRegisterBeanPostProcessor implements BeanFactoryPostProcessor, Ordered {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition pickachu = BeanDefinitionBuilder.rootBeanDefinition(PickachuFactoryBean.class)
            .addConstructorArgReference("demo-ru.sber.demo.PockemonConfigurationProperties")
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition("pickachu", pickachu);
    
    }
    
    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
