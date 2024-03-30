package ru.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import ru.demo.model.Pokemon;
import ru.demo.model.ZooWorker;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class PokedexBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        final String[] workers = beanFactory.getBeanNamesForType(ZooWorker.class, false, false);
        final String[] pokemons = beanFactory.getBeanNamesForType(Pokemon.class, false, false);
        for (String worker : workers) {
            
            final AbstractBeanDefinition pokedexBeanDefinition =
                BeanDefinitionBuilder.rootBeanDefinition(Pokedex.class).addConstructorArgReference(worker)
                    .addConstructorArgValue(pokemons).getBeanDefinition();
            
            registry.registerBeanDefinition("pokedex for" + worker, pokedexBeanDefinition);
        }
    }
}
