package ru.sber.demo.dsl.pockemon.wrong.pure;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import ru.sber.demo.dsl.pockemon.AbstractPockemonDslBeanFactoryPostProcessor;
import ru.sber.demo.dsl.pockemon.PockemonFactoryBean;
import ru.sber.demo.dsl.pockemon.PockemonMasterFactoryBean;

public class PureWrongPockemonDslBeanFactoryPostProcessor extends AbstractPockemonDslBeanFactoryPostProcessor {
    
    @Override
    protected void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                  String pockemonName) {
        RootBeanDefinition master = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PockemonMasterFactoryBean.class)
            .addConstructorArgReference(dslBeanName)
            .addConstructorArgReference(pockemonName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        beanFactory.registerBeanDefinition(masterName, master);
    }
    
    @Override
    protected void registerPockemon(BeanDefinitionRegistry beanFactory, String dslBeanName, String pockemonName) {
        RootBeanDefinition pockemon = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PockemonFactoryBean.class)
            .addConstructorArgReference("demo-ru.sber.demo.PockemonConfigurationProperties")
            .addConstructorArgReference(dslBeanName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        beanFactory.registerBeanDefinition(pockemonName, pockemon);
    }
}
