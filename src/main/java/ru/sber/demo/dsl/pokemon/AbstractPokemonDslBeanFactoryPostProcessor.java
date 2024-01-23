package ru.sber.demo.dsl.pokemon;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.Ordered;

import java.util.Arrays;

public abstract class AbstractPokemonDslBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Arrays.stream(
            beanFactory.getBeanNamesForType(PokemonDsl.class, false, false)
        ).forEach(dslBeanName -> registerBeanDefinitions((BeanDefinitionRegistry) beanFactory, dslBeanName));
    }
    
    private void registerBeanDefinitions(BeanDefinitionRegistry beanFactory, String dslBeanName) {
        String pokemonName = dslBeanName.replace("Dsl", "");
        registerPokemon(beanFactory, dslBeanName, pokemonName);
        registerMaster(beanFactory, dslBeanName, "master-for-" + dslBeanName, pokemonName);
    }
    
    protected abstract void registerPokemon(BeanDefinitionRegistry beanFactory, String dslBeanName, String pokemonName);
    
    protected abstract void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                           String pokemonName);
    
    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
