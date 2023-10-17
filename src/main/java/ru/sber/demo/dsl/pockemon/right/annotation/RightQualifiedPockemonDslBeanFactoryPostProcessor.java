package ru.sber.demo.dsl.pockemon.right.annotation;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import ru.sber.demo.dsl.pockemon.AbstractPockemonDslBeanFactoryPostProcessor;
import ru.sber.demo.dsl.pockemon.PockemonFactoryBean;
import ru.sber.demo.dsl.pockemon.PockemonMasterFactoryBean;
import ru.sber.demo.model.Pockemon;
import ru.sber.demo.model.PockemonMaster;

// See also ScopedProxyUtils
public class RightQualifiedPockemonDslBeanFactoryPostProcessor extends AbstractPockemonDslBeanFactoryPostProcessor {
    
    @Override
    protected void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                  String pockemonName) {

        RootBeanDefinition master = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PockemonMasterFactoryBean.class)
            .addConstructorArgReference(dslBeanName)
            .addConstructorArgReference(pockemonName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        master.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, PockemonMaster.class);
        beanFactory.registerBeanDefinition(masterName, master);
    }
    
    @Override
    protected void registerPockemon(BeanDefinitionRegistry beanFactory, String dslBeanName, String pockemonName) {
        RootBeanDefinition pockemon = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PockemonFactoryBean.class)
            .addConstructorArgReference("demo-ru.sber.demo.PockemonConfigurationProperties")
            .addConstructorArgReference(dslBeanName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        pockemon.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, Pockemon.class);

        copyQualifierMetadata(beanFactory, dslBeanName, pockemon);

        beanFactory.registerBeanDefinition(pockemonName, pockemon);
    }

    private void copyQualifierMetadata(
        BeanDefinitionRegistry beanFactory, String dslBeanName, RootBeanDefinition targetBeanDefinition) {

        BeanDefinition dslBeanDefinition = beanFactory.getBeanDefinition(dslBeanName);

        // Copy autowire settings from original bean definition.
        targetBeanDefinition.setAutowireCandidate(dslBeanDefinition.isAutowireCandidate());
        targetBeanDefinition.setPrimary(dslBeanDefinition.isPrimary());
        if (dslBeanDefinition instanceof AbstractBeanDefinition) {
            targetBeanDefinition.copyQualifiersFrom((AbstractBeanDefinition) dslBeanDefinition);
        }

        targetBeanDefinition.setDecoratedDefinition(new BeanDefinitionHolder(dslBeanDefinition, dslBeanName));
    }
}
