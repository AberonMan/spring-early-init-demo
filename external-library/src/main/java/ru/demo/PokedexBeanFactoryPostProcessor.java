package ru.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import ru.demo.model.Pokemon;
import ru.demo.model.ZooWorker;

public class PokedexBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
   
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        final String[] workers = beanFactory.getBeanNamesForType(ZooWorker.class);
        final String[] pokemons = beanFactory.getBeanNamesForType(Pokemon.class);
        for (String worker : workers) {
            
            final AbstractBeanDefinition pokedexBeanDefinition = BeanDefinitionBuilder
                .rootBeanDefinition(Pokedex.class)
                .addConstructorArgReference(worker)
                .addConstructorArgValue(pokemons)
                .getBeanDefinition();
            
            registry.registerBeanDefinition("pokedex for" + worker, pokedexBeanDefinition);
        }
    }
}
