package ru.sber.demo.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import ru.sber.demo.model.Pokemon;
import ru.sber.demo.model.PokemonZookeeper;
import ru.sber.demo.model.ZooWorker;

public class ZookeperDslBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final String[] workers = beanFactory.getBeanNamesForType(ZooWorker.class);
        final String[] pokemons = beanFactory.getBeanNamesForType(Pokemon.class);
        
        RootBeanDefinition pokemonZookeper =
            (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PokemonZookeeper.class)
                .addConstructorArgValue(pokemons)
                .addConstructorArgValue(workers)
                .setScope(BeanDefinition.SCOPE_SINGLETON).getBeanDefinition();
        
        ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition("zookeeper", pokemonZookeper);
    }
}
