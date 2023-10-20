package ru.sber.demo.dsl.keeper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.Ordered;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonKeeperBook;
import ru.sber.demo.model.PokemonZookeeper;
import ru.sber.demo.model.api.ZooWorker;

import java.util.Arrays;
import java.util.List;

public class PokemonZookeeperBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    
    private static final String KEEPER_BOOK_BEAN = "keeperBook";
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        List<String> workerNames = Arrays.asList(beanFactory.getBeanNamesForType(ZooWorker.class));
        List<String> pockemonNames = Arrays.asList(beanFactory.getBeanNamesForType(Pokemon.class));
        
        RootBeanDefinition book = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PokemonKeeperBook.class)
            .addConstructorArgValue(pockemonNames)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition(KEEPER_BOOK_BEAN, book);
        
        RootBeanDefinition zookeeper = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PokemonZookeeper.class)
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
