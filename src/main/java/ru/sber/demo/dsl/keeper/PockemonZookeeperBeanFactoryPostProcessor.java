package ru.sber.demo.dsl.keeper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.Ordered;
import ru.sber.demo.model.api.Pockemon;
import ru.sber.demo.model.PockemonKeeperBook;
import ru.sber.demo.model.PockemonZookeeper;
import ru.sber.demo.model.api.ZooWorker;

import java.util.Arrays;
import java.util.List;

public class PockemonZookeeperBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    
    private static final String KEEPER_BOOK_BEAN = "keeperBook";
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        List<String> workerNames = Arrays.asList(beanFactory.getBeanNamesForType(ZooWorker.class));
        List<String> pockemonNames = Arrays.asList(beanFactory.getBeanNamesForType(Pockemon.class));
        
        RootBeanDefinition book = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PockemonKeeperBook.class)
            .addConstructorArgValue(pockemonNames)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition(KEEPER_BOOK_BEAN, book);
        
        RootBeanDefinition zookeeper = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PockemonZookeeper.class)
            .addConstructorArgReference(KEEPER_BOOK_BEAN)
            .addConstructorArgValue(workerNames)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition("zookeeper", zookeeper);
    }
    
    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE + 1;
    }
}
